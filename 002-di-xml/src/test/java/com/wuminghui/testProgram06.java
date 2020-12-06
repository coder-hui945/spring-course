package com.wuminghui;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*给引用数据类型的属性赋值*/
public class testProgram06 {


    @Test
    public void test01(){
        String config = "package06/total.xml";/*加载总文件*/
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Object bean = ac.getBean("mystu");
        System.out.println(bean);

    }
}
