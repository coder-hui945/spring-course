package com.wuminghui;

import com.wuminghui.package02.School;
import com.wuminghui.package02.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*给引用数据类型的属性赋值*/
public class testProgram02 {
    @Test/*手动赋值*/
    public void test01(){
        Student student = new Student();
        student.setAge(25);
        student.setName("吴明辉");
        School school = new School();
        school.setAddress("内江市");
        school.setName("清华大学");
        student.setSchool(school);
        System.out.println(student);
    }

    @Test/*spring赋值*/
    public void test02(){
        String config = "package02/applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Object bean = ac.getBean("mystu");
        System.out.println(bean);
    }
}
