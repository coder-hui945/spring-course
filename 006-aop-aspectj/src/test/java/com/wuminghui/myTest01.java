package com.wuminghui;

import com.wuminghui.bao01.SomeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest01 {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ao = new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) ao.getBean("someService");
        /*这个SomeService对象已经不是单纯的SomeService对象了，它已经被配置文件中的<aop:aspectj-autoproxy/>
        * 执行的时候改造过了，是代理对象，加入了切面功能。（<aop:aspectj-autoproxy/>执行前是普通对象，没有切面功能）
        * */
        //通过代理对象执行方法，实现切面
        proxy.doSome("五五开",56);

    }
}
