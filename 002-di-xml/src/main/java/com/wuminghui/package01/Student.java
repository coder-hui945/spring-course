package com.wuminghui.package01;

public class Student {
    private String name;
    private int age;

    public Student() {
        System.out.println("调用无参构造方法");
    }

    public void setName(String name) {
        System.out.println("调用了setName方法");
        this.name = name;
    }

    public void setAge(int age) {
        System.out.println("调用了setAge方法");
        this.age = age;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
