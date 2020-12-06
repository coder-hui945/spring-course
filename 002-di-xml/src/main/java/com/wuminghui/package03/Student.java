package com.wuminghui.package03;

public class Student {
    private String name;
    private int age;
    private School school;
    public Student() {
        System.out.println("调用无参构造方法");
    }

    public Student(String name, int age, School school) {
        System.out.println("调用有参构造方法");
        this.name = name;
        this.age = age;
        this.school = school;
    }



    public void setName(String name) {

        this.name = name;
    }

    public void setSchool(School school) {

        this.school = school;
    }

    public void setAge(int age) {

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
