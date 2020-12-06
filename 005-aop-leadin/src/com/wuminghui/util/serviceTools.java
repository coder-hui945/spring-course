package com.wuminghui.util;

import java.util.Date;

public class serviceTools {
    public static void doLog(){
        System.out.println("非业务方法，方法的执行时间：" + new Date());
    }
    public static void doTrans(){
        System.out.println("非业务方法，方法执行后，提交事务");
    }
}
