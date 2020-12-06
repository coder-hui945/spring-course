package com.wuminghui.package02;

public class Student {
    private String name;
    private int age;
    private School school;
    public Student() {
        System.out.println("调用无参构造方法");
    }

    public void setName(String name) {
        System.out.println("调用了setName方法");
        this.name = name;
    }

    public void setSchool(School school) {
        System.out.println("调用setSchool方法");
        this.school = school;
    }

    public void setAge(int age) {
        System.out.println("调用了setAge方法");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
