package com.tianxi.mysearch;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 线程池的操作
 */
public class MainActivity extends Activity {
    @BindView(R.id.toobar)
    Toolbar toolbar;
//    @BindView(R.id.ed)
//    EditText editText;
//    @BindView(R.id.image)
//    ImageView imageView;

    @BindView(R.id.tv)
    TextView tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i < 20; i++){
            new Thread(new task()).start();
//            cachedThreadPool.submit(new task());
        }
//        for (int i = 1; i < 5; i++){
//            new Thread(new task()).start();
//
////            cachedThreadPool.submit(new task());
//        }
//        for (int i = 1; i < 5; i++){
//            new Thread(new task2()).start();
//
////            cachedThreadPool.submit(new task());
//        }
        /**
         * 限制线程的个数
         */
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 10; i++) {
//            fixedThreadPool.execute(new task());
//
//        }
        /**
         *  支持 延迟 周期性的线程池   支持线程个数
         */
//        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
//        for (int i = 0; i <10 ; i++) {
////            scheduledThreadPool.schedule(new task(), 3, TimeUnit.SECONDS);//  后边是单位
//            //延迟一秒 每三秒一次
//            scheduledThreadPool.scheduleAtFixedRate(new task(), 1, 1, TimeUnit.MILLISECONDS);
//        }
        /**
         * 单例   单一的线程
         */

//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//
//        for (int i = 0; i < 10; i++) {
//            singleThreadExecutor.execute(new task());
//
//        }

//        EnmuTest.instasnce.getInstance()
        EnmuTest.instancse.getInstance();

    }


    class task implements Runnable {

//        A a=new A();
        @Override
        public void run() {
            A a = A.getInstance();
//            try {
//                Thread.sleep(200);

            for (int i = 0; i < 20; i++) {
                try {
                    int ss= (int) ((i%10)*Math.random());
//                    Log.d("task", "ss:" + ss);
                    Thread.sleep(ss);



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a.c= --a.c;
//                a.c=++a.c;


//                int b = a.getB();
//                ++b;
//                a.c = b;
//                a.setB(b);
//
//                Log.d("task", "a.getB()="+a.getB() + "----- b=" + b + "-----a.c=" + a.c);
//                Log.d("task", "线程名字" + Thread.currentThread().getName());
                Log.d("task", "a.c:" + a.c);
            }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }

    }
    class task2 implements Runnable {
        A a = A.getInstance();
        @Override
        public void run() {
//            try {
//                Thread.sleep(200);

            a.c= ++a.c;
//                int b = a.getB();
//                ++b;
//                a.c = b;
//                a.setB(b);
//
//                Log.d("task", "a.getB()="+a.getB() + "----- b=" + b + "-----a.c=" + a.c);
//                Log.d("task", "线程名字" + Thread.currentThread().getName());
            Log.d("task", "a.c:" + a.c);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
    }
}