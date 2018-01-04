package com.dranawhite.forum.util;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.excel.XlsDataSet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 从EXCEL数据集文件创建Bean
 */
public class XlsDataSetBeanFactory {

    /**
     * 从DbUnit的EXCEL数据集文件创建多个bean
     */
    public static <T> List<T> createBeans(File file, String tableName,
            Class<T> clazz) throws Exception {
        BeanUtilsBean beanUtils = createBeanUtils();
        List<Map<String, Object>> propsList = createProps(file, tableName);
        List<T> beans = new ArrayList<>();
        for (Map<String, Object> props : propsList) {
            T bean = clazz.newInstance();
            beanUtils.populate(bean, props);
            beans.add(bean);
        }
        return beans;
    }

    /**
     * 从DbUnit的EXCEL数据集文件创建多个bean
     *
     * @param file
     * @param tableName
     * @param clazz
     * @param <T>
     *
     * @return
     *
     * @throws Exception
     */
    public static <T> T createBean(File file, String tableName, Class<T> clazz)
            throws Exception {
        BeanUtilsBean beanUtils = createBeanUtils();
        List<Map<String, Object>> propsList = createProps(file, tableName);
        T bean = clazz.newInstance();
        beanUtils.populate(bean, propsList.get(0));
        return bean;
    }

    private static List<Map<String, Object>> createProps(File file, String tableName) throws
            IOException, DataSetException {
        List<Map<String, Object>> propsList = new ArrayList<>();
        InputStream ins = new FileInputStream(file);
        IDataSet expected = new XlsDataSet(ins);
        ITable table = expected.getTable(tableName);
        Column[] columns = table.getTableMetaData().getColumns();
        for (int i = 0; i < table.getRowCount(); i++) {
            Map<String, Object> props = new HashMap<>();
            for (Column c : columns) {
                Object value = table.getValue(i, c.getColumnName());
                String propName = underlineToCamel(c.getColumnName());
                props.put(propName, value);
            }
            propsList.add(props);
        }
        return propsList;
    }

    private static String underlineToCamel(String str) {
        str = str.toLowerCase();
        String pattern[] = str.split("_");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < pattern.length; i++) {
            if (i == 0) {
                builder.append(pattern[i]);
            } else {
                builder.append(pattern[i].substring(0, 1).toUpperCase());
                builder.append(pattern[i].substring(1));
            }
        }
        return builder.toString();
    }

    private static BeanUtilsBean createBeanUtils() {
        ConvertUtilsBean convertUtilsBean = createConverUtils();
        return new BeanUtilsBean(convertUtilsBean);
    }

    private static ConvertUtilsBean createConverUtils() {
        DateTimeConverter dateConverter = new NullableDateConverter();
        dateConverter.setPattern("yyyy/MM/dd");
        ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();
        convertUtilsBean.register(dateConverter, java.util.Date.class);
        convertUtilsBean.register(dateConverter, Timestamp.class);
        convertUtilsBean.register(dateConverter, java.sql.Date.class);
        return convertUtilsBean;
    }

    static class NullableDateConverter extends DateTimeConverter {

        @Override
        protected Class<?> getDefaultType() {
            return Date.class;
        }

        @Override
        public <T> T convert(final Class<T> type, Object value) {
            if (value == null) {
                return null;
            }
            return super.convert(type, value);
        }
    }

}