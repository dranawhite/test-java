package com.dranawhite.common.unitils;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.unitils.dbunit.datasetfactory.DataSetFactory;
import org.unitils.dbunit.util.MultiSchemaDataSet;

import java.io.File;
import java.io.IOException;

/**
 * @author dranawhite 2018/1/3
 * @version 1.0
 */
public class MultiSchemaXlsDataSetFactoryTest {

    private File file;
    private DataSetFactory factory;

    @Before
    public void init() throws IOException {
        Resource resource = new FileSystemResource("/file/User.xlsx");
        file = resource.getFile();
        factory = new MultiSchemaXlsDataSetFactory();
    }

    @Test
    public void testCreateDataSet() {
        MultiSchemaDataSet dataSet = factory.createDataSet(file);
        System.out.println(dataSet);
    }

}
