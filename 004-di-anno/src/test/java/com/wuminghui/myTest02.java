package com.wuminghui;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest02 {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Object bean = ac.getBean("myStudent");
        System.out.println(bean);

    }
}
