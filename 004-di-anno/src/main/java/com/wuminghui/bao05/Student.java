package com.wuminghui.bao05;


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
    *               位置：1.在属性定义的上面，无需set方法。
    *                     2.在set方法上面。
    * */
            /*使用byName方式注入：
                    步骤：1.在属性的上面加@Autowired
                          2.在属性的上面加@Qualifier（value = "bean的id"）：表示使用指定名称的bean来
                            完成赋值。
            *注意：@Autowired默认属性@Autowired(required = true)表示赋值失败直接中断程序，false表示赋值失败，程序继续运行，只是赋的值为空。
            *推荐使用true。
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
