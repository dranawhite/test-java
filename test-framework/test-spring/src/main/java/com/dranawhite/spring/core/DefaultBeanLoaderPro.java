package com.dranawhite.spring.core;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * <pre>
 *     使用XmlBeanDefinitionReader和DefaultListableBeanFactory加载Bean
 * </pre>
 *
 * @author dranawhite 2017/12/18
 * @version 1.0
 */
public class DefaultBeanLoaderPro {

    public <T> T getBean(String path) throws IOException {
        //加载person.xml文件
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource(path);

        //BeanDefinition载入
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);

        return (T) factory.getBean("pn");
    }

}
