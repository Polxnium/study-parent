package com.stu.spring.bean.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanB implements BeanNameAware
        , BeanClassLoaderAware
        , ApplicationContextAware
        , BeanFactoryAware
        , InitializingBean
        , DisposableBean
        /*, BeanFactoryPostProcessor
        , BeanDefinitionRegistryPostProcessor*/
{

    public BeanB() {
        out("BeanB 构造器");
    }

    private BeanA beanA;

    @Autowired
    public void setBeanA(BeanA beanA) {
        out("BeanB 对属性beanA设置值");
        this.beanA = beanA;
    }

    @Override
    public void setBeanName(String name) {
        out("BeanB BeanNameAware.setBeanName(String name)");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        out("BeanB BeanClassLoaderAware.setBeanClassLoader(ClassLoader classLoader)");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        out("BeanB BeanFactoryAware.setBeanFactory(BeanFactory beanFactory)");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        out("BeanB ApplicationContextAware.setApplicationContext(ApplicationContext applicationContext)");
    }

    @PostConstruct
    public void init() {
        out("BeanB @PostConstruct");
    }

    @Override
    public void afterPropertiesSet() {
        out("BeanB InitializingBean.afterPropertiesSet()");
    }

    @PreDestroy
    public void destroyMethod() {
        out("BeanB @PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        out("BeanB DisposableBean.destroy()");
    }

    private void out(String message) {
        System.out.println(message);
    }

    /*@Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        out("BeanB BeanFactoryPostProcessor.postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        out("BeanB BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry)");
    }*/

}
