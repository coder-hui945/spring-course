package com.wuminghui;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*给引用数据类型的属性赋值*/
public class testProgram05 {


    @Test/*自动注入：byType*/
    public void test01(){
        String config = "package05/applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Object bean = ac.getBean("mystu");
        System.out.println(bean);

    }
}
