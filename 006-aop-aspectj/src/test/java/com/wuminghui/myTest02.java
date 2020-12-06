package com.wuminghui;

import com.wuminghui.bao02.SomeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.transform.Source;

public class myTest02 {
    @Test/*测试后置通知*/
    public void test01(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ao = new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) ao.getBean("someService");

        int res = proxy.doOther("吴明辉", 25);
        System.out.println("返回结果===" + res);

    }
}
