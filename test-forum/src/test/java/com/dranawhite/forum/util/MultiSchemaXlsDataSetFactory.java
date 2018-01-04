package com.dranawhite.forum.util;

import org.unitils.core.UnitilsException;
import org.unitils.dbunit.datasetfactory.DataSetFactory;
import org.unitils.dbunit.util.MultiSchemaDataSet;

import java.io.File;
import java.util.Arrays;
import java.util.Properties;

/**
 * Unitils操作Excel数据
 *
 * @author dranawhite
 */
public class MultiSchemaXlsDataSetFactory implements DataSetFactory {

    protected String defaultSchemaName;

    @Override
    public void init(Properties configuration, String defaultSchemaName) {
        this.defaultSchemaName = defaultSchemaName;
    }

    @Override
    public MultiSchemaDataSet createDataSet(File... dataSetFiles) {
        try {
            MultiSchemaXlsDataSetReader xlsDataSetReader = new MultiSchemaXlsDataSetReader(
                    defaultSchemaName);
            return xlsDataSetReader.readDataSetXls(dataSetFiles);
        } catch (Exception e) {
            throw new UnitilsException(
                    "Unable to create DbUnit dataset for data set files:" + Arrays
                            .toString(dataSetFiles), e);
        }
    }

    @Override
    public String getDataSetFileExtension() {
        return "xlsx";
    }

}
