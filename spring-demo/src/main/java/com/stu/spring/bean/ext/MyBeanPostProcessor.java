package com.stu.spring.bean.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("beanB".equals(beanName)) {
            out("BeanB BeanPostProcessor.postProcessBeforeInitialization(Object bean, String beanName)");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("beanB".equals(beanName)) {
            out("BeanB BeanPostProcessor.postProcessAfterInitialization(Object bean, String beanName)");
        }
        return bean;
    }

    private void out(String message) {
        System.out.println(message);
    }
}
