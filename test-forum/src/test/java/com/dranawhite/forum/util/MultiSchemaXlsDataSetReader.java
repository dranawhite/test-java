package com.dranawhite.forum.util;

import org.apache.commons.lang.StringUtils;
import org.dbunit.dataset.AbstractTable;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.DefaultTableMetaData;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.ITableMetaData;
import org.dbunit.dataset.excel.XlsDataSet;
import org.unitils.core.UnitilsException;
import org.unitils.dbunit.util.MultiSchemaDataSet;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Unitils Excel文件读取器
 *
 * @author dranawhite
 */
public class MultiSchemaXlsDataSetReader {

    private String defaultSchemaName;

    public MultiSchemaXlsDataSetReader(String defaultSchemaName) {
        this.defaultSchemaName = defaultSchemaName;
    }

    public MultiSchemaDataSet readDataSetXls(File... dataSetFiles) {
        try {
            Map<String, List<ITable>> tableMap = getTables(dataSetFiles);
            MultiSchemaDataSet dataSets = new MultiSchemaDataSet();
            for (Entry<String, List<ITable>> entry : tableMap.entrySet()) {
                List<ITable> tables = entry.getValue();
                DefaultDataSet ds = new DefaultDataSet(tables.toArray(new ITable[] {}));
                dataSets.setDataSetForSchema(entry.getKey(), ds);
            }
            return dataSets;
        } catch (Exception e) {
            throw new UnitilsException("Unable to parse data set xls.", e);
        }
    }

    private Map<String, List<ITable>> getTables(File... dataSetFiles) {
        String pattern = "\\.";
        Map<String, List<ITable>> tableMap = new HashMap<>(16);
        try {
            for (File file : dataSetFiles) {
                IDataSet dataSet = new XlsDataSet(new FileInputStream(file));
                String[] tableNames = dataSet.getTableNames();
                for (String each : tableNames) {
                    String schema;
                    String tableName;
                    String[] temp = each.split(pattern);
                    if (temp.length == 2) {
                        schema = temp[0];
                        tableName = temp[1];
                    } else {
                        schema = this.defaultSchemaName;
                        tableName = each;
                    }
                    ITable table = dataSet.getTable(each);
                    if (!tableMap.containsKey(schema)) {
                        tableMap.put(schema, new ArrayList<>());
                    }
                    tableMap.get(schema).add(new XlsTable(tableName, table));
                }
            }
        } catch (Exception e) {
            throw new UnitilsException("Unable to parse data set xls. " + Arrays.toString(dataSetFiles), e);
        }
        return tableMap;
    }

    class XlsTable extends AbstractTable {

        private ITable delegate;
        private String tableName;

        public XlsTable(String tableName, ITable table) {
            this.delegate = table;
            this.tableName = tableName;
        }

        @Override
        public int getRowCount() {
            return delegate.getRowCount();
        }

        @Override
        public ITableMetaData getTableMetaData() {
            ITableMetaData meta = delegate.getTableMetaData();
            try {
                return new DefaultTableMetaData(tableName, meta.getColumns(),
                        meta.getPrimaryKeys());
            } catch (DataSetException e) {
                throw new UnitilsException("Don't get the meta info from " + meta, e);
            }
        }

        @Override
        public Object getValue(int row, String column) throws DataSetException {
            Object delta = delegate.getValue(row, column);
            if (delta instanceof String) {
                if (StringUtils.isEmpty((String) delta)) {
                    return null;
                }
            }
            return delta;
        }
    }
}
