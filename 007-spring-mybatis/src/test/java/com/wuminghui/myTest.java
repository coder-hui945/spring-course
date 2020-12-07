package com.wuminghui;

import com.wuminghui.dao.StudentDao;
import com.wuminghui.domain.Student;
import com.wuminghui.service.StudentService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class myTest {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext co = new ClassPathXmlApplicationContext(config);
        String[] names = co.getBeanDefinitionNames();
        for (String t:names) {
            System.out.println("容器中对象名称：：" + t + "||" + co.getBean(t).getClass().getName());
        }
    }
    @Test
    public void test02(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext co = new ClassPathXmlApplicationContext(config);
       //获取spring容器中的dao对象
        StudentDao dao = (StudentDao) co.getBean("studentDao");
        Student student = new Student(1235,"terminator",1001);
        int nums = dao.insertStudent(student);
        System.out.println("nums===" + nums);

    }
    @Test/***插入****/
    public void test03(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext co = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentService service = (StudentService)co.getBean("studentService");
        Student student = new Student(69,"无类",100);
        int nums = service.addStudent(student);
        //spring与mybatis整合在一起使用，事务是自动提交的，无需执行SqlSession.commit()来提交事务。
        System.out.println("nums===" + nums);

    }
    @Test/****查询****/
    public void test04(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext co = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentService service = (StudentService)co.getBean("studentService");
        List<Student> students = service.queryStudents();
        for (Student stu:students) {
            System.out.println("查询信息：：：" + stu);
        }

    }
}
