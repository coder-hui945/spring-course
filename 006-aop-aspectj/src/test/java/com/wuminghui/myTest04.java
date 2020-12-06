package com.wuminghui;

import com.wuminghui.bao04.SomeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest04 {
    @Test/*测试后置通知*/
    public void test01(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ao = new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) ao.getBean("someService");

        Object res = proxy.doOther("wuminghui",25);

    }
}
