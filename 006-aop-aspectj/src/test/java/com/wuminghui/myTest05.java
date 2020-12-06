package com.wuminghui;
import com.wuminghui.bao05.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest05 {
    @Test/*系统默认：定义有接口，使用的是JDK动态代理，当删除接口后使用spring框架提供的CGlib动态代理
                系统会自动识别，并用相应的动态代理去实现aop，
                但是可以在有接口时也用CGlib动态代理来处理（需要配置，方法见配置文件），CGlib动态代理比JDK的强大。
                CGlib动态代理方式：com.wuminghui.bao05.SomeServiceIm
                */

    public void test01(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ao = new ClassPathXmlApplicationContext(config);
        SomeServiceImpl bean = (SomeServiceImpl) ao.getBean("someService");
        bean.doOther("吴明辉",25);
        System.out.println("动态代理方式：" + bean.getClass().getName());

    }
}
