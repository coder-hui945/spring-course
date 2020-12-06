package com.wuminghui.bao01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

//切面类
//@Aspect是aspectj框架中的注解，表示当前类是切面类
//切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码。
//使用位置：类定义的上面。
@Aspect
public class myAspect {
    /*定义通知方法，实现切面功能。
        定义要求：1.必须是公共方法public
                  2.方法不能有返回值void
                  3.方法名称自定义
                  4.方法参数可有，也可以没有（参数不是自定义的，只有几个参数提供选择）

    *
    * */
   /* 切面功能一：输出时间(目标方法执行之前输出时间，需要加前置通知注解@Before)
    @Before  属性：value，是切入点表达式exceution，表示切面执行的位置。
    使用位置：方法上面
    特点：1.在目标方法之前执行
            2.不会改变目标方法执行的结果
            3.不会影响目标方法的执行
    */
    /*写法一*/
    /*@Before(value = "execution(void doSome(String,int))")
    public void myBefore(){
        System.out.println("方法执行的时间为：" + new Date());
    }*/
    /*写法二*/
    /*@Before(value = "execution(* do*(..))")
    public void myBefore(){
        System.out.println("方法执行的时间为：" + new Date());
    }*/

    /*指定通知方法中的参数：JoinPoint（可以用在全部通知注解中）
    *       JoinPoint：代表的是被切面植入的业务方法（切入点）
    *       作用：可以在通知方法中获取方法执行的信息。比如：方法名称，方法实参。
    *       当你的切面功能中需要用到方法的信息时使用JoinPoint。
    * 使用要求：JoinPoint参数值必须按框架要求，必须作为通知方法的第一个参数，框架会给它赋予方法信息。
    *
    *   */
    @Before(value = "execution(* do*(..))")
    public void myBefore(JoinPoint jp){/*doSome函数的所有信息会赋给jp*/
        /*获取方法的完整定义*/
        System.out.println("方法的签名（定义）：" + jp.getSignature());
        System.out.println("方法的名称：" + jp.getSignature().getName());
        /*获取方法的实参*/
        Object[] args = jp.getArgs();

        for (Object t:args) {
            System.out.println("参数：" + t);
        }
        System.out.println("方法执行的时间为：" + new Date());
    }
}
