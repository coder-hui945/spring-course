package com.wuminghui.excep;


//自定义的运行时异常类
public class NotEnoughException extends RuntimeException{
       public NotEnoughException(){
           super();
       }
       public NotEnoughException(String message){
           super(message);
       }
}
