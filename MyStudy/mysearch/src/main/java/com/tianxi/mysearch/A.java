package com.tianxi.mysearch;

import java.io.Serializable;

/**
 * Created by admin on 17/4/12.
 */

public class A implements Serializable {
    private static  A instance;
    private int b=0;

    public   int c=1000;

    public  static A getInstance() {

//        if (instance != null) {
//            return instance;
//        } else {
//            instance = new A();
//            return  instance;
//        }
//        if(instance == null) {
////            synchronized (A.class){
//                A temp = instance;
//                if(temp == null) {
//                    temp = new A();
//                    instance = temp;
//                }
//            }
////        }
//        return instance;

/**
 * 饱汉式
 */
//        if (instance == null) {
//
//        return new A();
//        }
//        return instance;

        /**
         * 饿汉式
         */
        return  null;
    }

    public A() {


    }





    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }


}
