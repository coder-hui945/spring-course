package com.wuminghui;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/*给引用数据类型的属性赋值*/
public class testProgram03 {


    @Test/*spring赋值2:构造注入*/
    public void test02(){
        String config = "package03/applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Object bean = ac.getBean("mystu");
        System.out.println(bean);
        Object mystu2 = ac.getBean("mystu2");
        System.out.println(mystu2);
        //注入文件类型
        File myfile = (File) ac.getBean("myfile");
        System.out.println(myfile.getName());
    }
}
