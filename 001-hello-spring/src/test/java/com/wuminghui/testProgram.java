package com.wuminghui;

import com.wuminghui.service.SomeService;
import com.wuminghui.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.util.Date;

public class testProgram {
    @Test/*以主动的方式完成对象的创建*/
    public void test01(){
        SomeServiceImpl service = new SomeServiceImpl();
        service.doSome();
   }

   @Test/*使用spring容器创建的对象*/
   /*spring默认创建对象的时间是在spring创建ClassPathXmlApplicationContext容器时，读取路径，找到配置文件，
   * 并创建配置文件中的所有声明的类的对象，并存放在这个容器中
   * spring创建对象：默认调用的是无参构造方法
   * */
    public void test02(){
        //1.指定spring配置文件的名称
       String config = "beans.xml";
       //创建表示spring容器的对象ApplicationContext，ApplicationContext（它是接口，要用他的实现类ClassPathXmlApplicationContext(配置文件的路径)）就表示spring容器
       //通过该容器对象就能获取spring创建的对象了
       //ClassPathXmlApplicationContext(路径)表示从类路径中去加载spring配置文件（从编译过后的class文件下的目录路径开始）
       ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取某个对象，并调用该对象的方法  getBean("配置文件中声明类的id")
       SomeService service = (SomeService) ac.getBean("someService");
       service.doSome();

   }
    @Test/*获取spring容器中Java对象的信息：1.可以查看配置文件 2.通过下列方法*/
    public void test03(){
        String config = "beans.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //使用spring提供的方法，获取容器中定义对象的数量
        int count = ac.getBeanDefinitionCount();
        System.out.println("在容器中定义的对象数量 = " + count);
        //获取容器中每个定义的对象的名称
        String[] names = ac.getBeanDefinitionNames();
        for (String name:names) {

            System.out.println("名称:" + name);
        }

    }

    @Test
    public void test04(){//获取一个非自定义的对象
        String config = "beans.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Date mydate = (Date) ac.getBean("mydate");
        System.out.println(mydate);


    }


}
