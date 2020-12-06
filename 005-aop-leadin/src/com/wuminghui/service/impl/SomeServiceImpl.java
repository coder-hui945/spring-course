package com.wuminghui.service.impl;

import com.wuminghui.service.SomeService;
import com.wuminghui.util.serviceTools;


//动态代理：原来的代码不修改任何地方，也能够增加其自生的功能，比如：输出执行时间，提交事务等等
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {

        System.out.println("doSome......");

    }

    @Override
    public void doOther() {

        System.out.println("doOther。。。。。。");

    }
}
