package com.wuminghui.bao07;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "myStudent")
public class Student {
    @Value(value = "张飞")
    private String name;
    @Value(value = "67")
    private int age;
/*引用类型赋值：
*       @Resource：来自JDK的注解，spring框架提供了对这个注解的功能支持，可以给引用类型赋值。
*                   也是自动注入的原理，支持byName  byType 默认byName
*                 位置：1.在属性定义的上面，无需set方法。（推荐）
 *                     2.在set方法上面。
*       注意：@Resource会先使用byName，如果注入失败，会自动再用byType。
*
*       只使用byName的方式：需要加入一个属性name,  name = "bean的id"
* */
   @Resource(name = "myschool")
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
