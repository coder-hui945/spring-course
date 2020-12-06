package com.wuminghui.bao04;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "myStudent")
public class Student {
    /*
     * 简单类型的属性赋值：@Value
     *           属性value是string类型的，表述简单类型的属性值。
     *           位置：1.在属性定义的上面，无需set方法就可以赋值，推荐使用。
     *                 2.在set方法的上面。
     *
     * */
    @Value(value = "张飞")
    private String name;
    @Value(value = "67")
    private int age;
    /*          应用类型的赋值：
    * 方法一：@Autowired：spring框架提供的注解，实现引用类型的赋值。使用的是自动注入原理。
    *（需要同源对象）   支持byName  byType。默认使用的是byType
    *               属性：required，是一个boolean类型的，默认true
    *                           required = true：（推荐，方便调试）表示如果引用类型赋值失败，程序报错，并终止执行。
    *                           required = false：引用类型如果赋值失败，不报错，继续正常执行，引用类型赋值null。
    *               位置：1.在属性定义的上面，无需set方法。
    *                     2.在set方法上面。
    * */
            /*使用byName方式注入：
                    步骤：1.在属性的上面加@Autoired
                          2.在属性的上面加@Qualifier（value = "bean的id"）：表示使用指定名称的bean来
                            完成赋值。
            *需要两个注解同时使用！
            *
            * */
    @Autowired
    @Qualifier(value = "myschool")
    private School school;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }

    public String getName() {
        return name;
    }

    /*public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }*/

    public int getAge() {
        return age;
    }


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }
}
