package com.wuminghui.bao01;


import org.springframework.stereotype.Component;
/*
*
* @component（组件）注解是用来创建对象的，等同于<bean>的功能
*       属性value，指的是对象的名称。相当于bean的id，都必须唯一。
*       注解位置：类的上面。
* spring创建完成后任然是放在容器之中的。
* spring中和@component功能一样，创建对象的注解还有：
*       1.@Repository：（仓库）（用在持久层类的上面）放在dao实现类上面，用于创建dao对象，dao对象用来访问数据库的。
*       2.@Service：（用在业务层类的上面），放在service的实现类上面，创建service对象，用于业务处理，可以有业务等功能。
*       3.@Controller（用在控制器上面）放在控制器（处理器）类的上面，创建控制器对象，能够显示用户提交的参数，显示请求处理的结果的。
*       该三个注解使用语法和component一样，都能创建对象，但是还有额外功能，更强大。
* @Repository  @Service  @Controller是给项目的对象分层的。
*
*  */
@Component(value = "myStudent")
/*注解规定，只写value可以省略，也就可以携程：@component（"myStudent"）*/
/*也可以不指定生成对象的名称，由spring提供类名
写成：@component
默认spring提供的对象名称为定义的类名首字母小写。
* */
public class Student {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }
}
