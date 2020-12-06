package com.wuminghui.bao05;

//目标类
public class SomeServiceImpl  {

    public void doSome(String name,int age) {
        //给doSome方法增加功能，在方法执行之前输出执行的时间。
        System.out.println("=======目标方法doSome（）========");
    }


    public int doOther(String name, int age) {
        System.out.println("=======目标方法doOther（）========");
        return 99;
    }


    public String doFirst(String name, int age) {

        System.out.println("=======目标方法doFirst（）========");
        return "doFirst";
    }
}
