package com.dranawhite.common.excel;

import org.junit.Test;

/**
 * @author dranawhite 2017/10/26
 * @version 1.0
 */
public class WorkBookTest {

    private WorkBook workBook = new WorkBook();

    @Test
    public void writeWorkBookTest() {
        workBook.writeWorkBook();
    }

    @Test
    public void readWorkBookTest() {
        workBook.readWorkBook();
    }

    @Test
    public void createCellTest() {
        workBook.createCell();
    }

    @Test
    public void updateCellStyleTest() {
        workBook.updateCellStyle();
    }
}
