package com.tianxi.mystudy.rxandroid.javatest;

/**
 * Created by admin on 16/10/20.
 */

public class B extends A {
    private  static  int anInt;

    {
        System.out.print("B静态代码块\n");

    }
    public B() {
        super();
        System.out.print("B构造器\n");


    }
}
