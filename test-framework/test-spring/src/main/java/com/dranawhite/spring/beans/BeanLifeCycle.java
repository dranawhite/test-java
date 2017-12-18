package com.dranawhite.spring.beans;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 *  InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation
 *  调用Car()构造函数。
 *  InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation
 *  InstantiationAwareBeanPostProcessor.postProcessPropertyValues
 *  调用setBrand()设置属性。
 *  调用BeanNameAware.setBeanName()。
 *  调用BeanFactoryAware.setBeanFactory()。
 *  调用BeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黑色。
 *  调用InitializingBean.afterPropertiesSet()。
 *  调用myInit()，将maxSpeed设置为240。
 *  调用BeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为200。
 *  introduce:brand:红旗CA72/color:黑色/maxSpeed:200
 *  car1==car2:true
 *  调用DisposableBean.destory()。
 *  调用myDestroy()。
 */
public class BeanLifeCycle {

    private void lifeCycleInBeanFactory() {

        //①下面两句装载配置文件并启动容器
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:beans/applicationContext-beans.xml");

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);

        //②向容器中注册MyBeanPostProcessor后处理器, ConfigurableBeanFactory提供
        factory.addBeanPostProcessor(new CarBeanPostProcessor());

        //③向容器中注册MyInstantiationAwareBeanPostProcessor后处理器，ConfigurableBeanFactory提供
        factory.addBeanPostProcessor(new CarInstantiationAwareBeanPostProcessor());

        //④第一次从容器中获取car，将触发容器实例化该Bean，这将引发Bean生命周期方法的调用。
        Car car1 = (Car) factory.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        //⑤第二次从容器中获取car，直接从缓存池中获取
        Car car2 = (Car) factory.getBean("car");

        //⑥查看car1和car2是否指向同一引用
        System.out.println("car1==car2:" + (car1 == car2));
        //⑦关闭容器
        factory.destroySingletons();
    }

    public static void main(String[] args) {
        BeanLifeCycle beanLifeCycle = new BeanLifeCycle();
        beanLifeCycle.lifeCycleInBeanFactory();
    }
}
