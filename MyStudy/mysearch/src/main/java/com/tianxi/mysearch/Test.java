//package com.tianxi.mysearch;
//
//import android.util.Log;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * Created by admin on 17/4/12.
// */
//
//public class Test {
//    A a = A.getInstance();
//    public static void main(String[] args) {
//
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        for (int i = 1; i < 10; i++){
//            cachedThreadPool.submit(new task());
//        }
//
//
//
//    }
//    static class task implements Runnable {
//
//        @Override
//        public void run() {
//            try {
//                int b = a.getB();
//                ++b;
//                a.c = b;
//                a.setB(b);
//                Thread.sleep(1000);
//                Log.d("task", a.getB() + "----- b=" + b + "-----a.c=" + a.c);
//                Log.d("task", Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}


