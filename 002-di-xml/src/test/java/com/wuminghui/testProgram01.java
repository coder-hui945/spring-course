package com.wuminghui;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testProgram01 {
   @Test
    public void test01(){
       String config = "package01/applicationContext.xml";
       ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
      Object mystu = ac.getBean("mystu");
      System.out.println("student对象=" + mystu);

   }

}
