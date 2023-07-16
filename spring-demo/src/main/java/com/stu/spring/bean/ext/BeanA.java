package com.stu.spring.bean.ext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanA {

    public BeanA () {
        System.out.println("BeanA 构造器");
    }

    private BeanB beanB;

    @Autowired
    public void setBeanB(BeanB beanB) {
        System.out.println("BeanA 对属性beanB设置值");
        this.beanB = beanB;
    }
}
