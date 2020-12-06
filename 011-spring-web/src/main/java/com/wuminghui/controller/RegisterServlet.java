package com.wuminghui.controller;


import com.wuminghui.domain.Student;
import com.wuminghui.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id");
        String strName = request.getParameter("name");
        String strAge = request.getParameter("age");
        //创建spring的容器对象
        String config = "applicationContext.xml";
        ApplicationContext ao = new ClassPathXmlApplicationContext(config);
        System.out.println("容器对象的信息=======" + ao);
        //获取service
        StudentService service = (StudentService) ao.getBean("studentService");
        Student student = new Student();
        student.setId(Integer.parseInt(strId));
        student.setName(strName);
        student.setAge(Integer.parseInt(strAge));
        service.addStudent(student);
        //给一个页面，显示结果
        System.out.println("++++++++++++++++");
        request.getRequestDispatcher("/result.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

}
