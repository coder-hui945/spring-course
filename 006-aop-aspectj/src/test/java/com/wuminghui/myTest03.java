package com.wuminghui;

import com.wuminghui.bao03.SomeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest03 {
    @Test/*测试后置通知*/
    public void test01(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ao = new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) ao.getBean("someService");

        Object res = proxy.doFirst("吴明辉", 25); //doFirst已经被包装成了myAround,实际调用的myAround函数，返回值也是myAround的。
        System.out.println("返回结果===" + res);

    }
}
