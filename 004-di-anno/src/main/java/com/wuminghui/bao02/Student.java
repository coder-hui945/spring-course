package com.wuminghui.bao02;


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

    /*public void setName(String name) {
        this.name = name;
    }
    @value("30")直接放在set方法之上，完成赋值
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
