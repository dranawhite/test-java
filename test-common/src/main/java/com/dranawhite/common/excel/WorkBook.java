package com.dranawhite.common.excel;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 工作簿
 *
 * @author dranawhite 2017/10/26
 * @version 1.0
 */
public class WorkBook {

    /**
     * 创建工作簿
     */
    public void writeWorkBook() {
        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet("Employee Info ");
        //Create row object
        XSSFRow row;
        //This data needs to be written (Object[])
        Map<String, Object[]> empinfo = new TreeMap<>();
        empinfo.put("1", new Object[] { "EMP ID", "EMP NAME", "DESIGNATION" });
        empinfo.put("2", new Object[] { "tp01", "Gopal", "Technical Manager" });
        empinfo.put("3", new Object[] { "tp02", "Manisha", "Proof Reader" });
        empinfo.put("4", new Object[] { "tp03", "Masthan", "Technical Writer" });
        empinfo.put("5", new Object[] { "tp04", "Satish", "Technical Writer" });
        empinfo.put("6", new Object[] { "tp05", "Krishna", "Technical Writer" });
        //Iterate over data and write to sheet
        Set<String> keyid = empinfo.keySet();
        int rowid = 0;
        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = empinfo.get(key);
            int cellid = 0;
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }

        CellRangeAddress rangeAddress = new CellRangeAddress(3, 5, 2, 2);
        spreadsheet.addMergedRegion(rangeAddress);
        //Write the workbook in file system
        try (FileOutputStream out = new FileOutputStream(new File("./file/测试工作簿.xlsx"))) {
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取工作簿
     */
    public void readWorkBook() {
        XSSFRow row;
        try (FileInputStream fis = new FileInputStream(new File("./file/测试工作簿.xlsx"))) {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet spreadsheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = spreadsheet.iterator();
            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(
                                    cell.getNumericCellValue() + " \t\t ");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(
                                    cell.getStringCellValue() + " \t\t ");
                            break;
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建单元格
     */
    public void createCell() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("cell types");
        XSSFRow row = spreadsheet.createRow((short) 2);
        row.createCell(0).setCellValue("Type of Cell");
        row.createCell(1).setCellValue("cell value");
        row = spreadsheet.createRow((short) 3);
        row.createCell(0).setCellValue("set cell type BLANK");
        row.createCell(1);
        row = spreadsheet.createRow((short) 4);
        row.createCell(0).setCellValue("set cell type BOOLEAN");
        row.createCell(1).setCellValue(true);
        row = spreadsheet.createRow((short) 5);
        row.createCell(0).setCellValue("set cell type ERROR");
        row.createCell(1).setCellValue(XSSFCell.CELL_TYPE_ERROR);
        row = spreadsheet.createRow((short) 6);
        row.createCell(0).setCellValue("set cell type date");
        row.createCell(1).setCellValue(new Date());
        row = spreadsheet.createRow((short) 7);
        row.createCell(0).setCellValue("set cell type numeric");
        row.createCell(1).setCellValue(20);
        row = spreadsheet.createRow((short) 8);
        row.createCell(0).setCellValue("set cell type string");
        row.createCell(1).setCellValue("A String");
        try (FileOutputStream out = new FileOutputStream(new File("./file/测试单元格.xlsx"))) {
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更改单元格样式
     */
    public void updateCellStyle() {
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建Sheet页
        XSSFSheet spreadsheet = workbook.createSheet("cellstyle");
        //创建行
        XSSFRow row = spreadsheet.createRow((short) 1);
        row.setHeight((short) 800);
        //创建单元格
        XSSFCell cell = row.createCell((short) 1);
        cell.setCellValue("test of merging");
        //合并单元格
        //this statement for merging cells
        spreadsheet.addMergedRegion(new CellRangeAddress(
                1, //first row (0-based)
                1, //last row (0-based)
                1, //first column (0-based)
                4 //last column (0-based)
        ));
        //CELL Alignment
        row = spreadsheet.createRow(5);
        cell = row.createCell(0);
        row.setHeight((short) 800);
        // Top Left alignment
        XSSFCellStyle style1 = workbook.createCellStyle();
        spreadsheet.setColumnWidth(0, 8000);
        style1.setAlignment(XSSFCellStyle.ALIGN_LEFT);
        style1.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
        cell.setCellValue("Top Left");
        cell.setCellStyle(style1);
        row = spreadsheet.createRow(6);
        cell = row.createCell(1);
        row.setHeight((short) 800);
        // Center Align Cell Contents
        XSSFCellStyle style2 = workbook.createCellStyle();
        style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(
                XSSFCellStyle.VERTICAL_CENTER);
        cell.setCellValue("Center Aligned");
        cell.setCellStyle(style2);
        row = spreadsheet.createRow(7);
        cell = row.createCell(2);
        row.setHeight((short) 800);
        // Bottom Right alignment
        XSSFCellStyle style3 = workbook.createCellStyle();
        style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
        style3.setVerticalAlignment(XSSFCellStyle.VERTICAL_BOTTOM);
        cell.setCellValue("Bottom Right");
        cell.setCellStyle(style3);
        row = spreadsheet.createRow(8);
        cell = row.createCell(3);
        // Justified Alignment
        XSSFCellStyle style4 = workbook.createCellStyle();
        style4.setAlignment(XSSFCellStyle.ALIGN_JUSTIFY);
        style4.setVerticalAlignment(
                XSSFCellStyle.VERTICAL_JUSTIFY);
        cell.setCellValue("Contents are Justified in Alignment");
        cell.setCellStyle(style4);
        //CELL BORDER
        row = spreadsheet.createRow((short) 10);
        row.setHeight((short) 800);
        cell = row.createCell((short) 1);
        cell.setCellValue("BORDER");
        XSSFCellStyle style5 = workbook.createCellStyle();
        style5.setBorderBottom(XSSFCellStyle.BORDER_THICK);
        style5.setBottomBorderColor(
                IndexedColors.BLUE.getIndex());
        style5.setBorderLeft(XSSFCellStyle.BORDER_DOUBLE);
        style5.setLeftBorderColor(
                IndexedColors.GREEN.getIndex());
        style5.setBorderRight(XSSFCellStyle.BORDER_HAIR);
        style5.setRightBorderColor(
                IndexedColors.RED.getIndex());
        style5.setBorderTop(XSSFCellStyle.BIG_SPOTS);
        style5.setTopBorderColor(
                IndexedColors.CORAL.getIndex());
        cell.setCellStyle(style5);
        //Fill Colors
        //background color
        row = spreadsheet.createRow((short) 10);
        cell = row.createCell((short) 1);
        XSSFCellStyle style6 = workbook.createCellStyle();
        style6.setFillBackgroundColor(
                HSSFColor.LEMON_CHIFFON.index);
        style6.setFillPattern(XSSFCellStyle.LESS_DOTS);
        style6.setAlignment(XSSFCellStyle.ALIGN_FILL);
        spreadsheet.setColumnWidth(1, 8000);
        cell.setCellValue("FILL BACKGROUNG/FILL PATTERN");
        cell.setCellStyle(style6);
        //Foreground color
        row = spreadsheet.createRow((short) 12);
        cell = row.createCell((short) 1);
        XSSFCellStyle style7 = workbook.createCellStyle();
        style7.setFillForegroundColor(HSSFColor.BLUE.index);
        style7.setFillPattern(XSSFCellStyle.LESS_DOTS);
        style7.setAlignment(XSSFCellStyle.ALIGN_FILL);
        cell.setCellValue("FILL FOREGROUND/FILL PATTERN");
        cell.setCellStyle(style7);
        try (FileOutputStream out = new FileOutputStream(new File("./file/测试单元格样式.xlsx"))) {
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

