package com.wuminghui;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/*给引用数据类型的属性赋值*/
public class testProgram04 {


    @Test/*spring赋值2:构造注入*/
    public void test01(){
        String config = "package04/applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Object bean = ac.getBean("mystu");
        System.out.println(bean);

    }
}
