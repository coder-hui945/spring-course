package com.wuminghui.bao01;

//目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,int age) {
        //给doSome方法增加功能，在方法执行之前输出执行的时间。
        System.out.println("=======目标方法doSome（）========");
    }
}
