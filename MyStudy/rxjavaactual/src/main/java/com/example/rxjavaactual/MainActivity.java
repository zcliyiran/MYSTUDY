package com.example.rxjavaactual;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.rxjavaactual.rxactualdemo02.Caller;
import com.example.rxjavaactual.rxactualdemo02.Fun1;
import com.example.rxjavaactual.rxactualdemo02.Receiver;

/**
 * @author admin
 */
public class MainActivity extends AppCompatActivity {
    /**
     * 1抽象主题角色： 把所有对观察者对象的引用保存在一个集合中，每个抽象主题角色都可以有任意数量的观察者。
     * 抽象主题提供一个接口，可以增加和删除观察者角色。一般用一个抽象类和接口来实现。
     * 2抽象观察者角色：为所有具体的观察者定义一个接口，在得到主题的通知时更新自己。
     * 3具体主题角色：在具体主题内部状态改变时，给所有登记过的观察者发出通知。具体主题角色通常用一个子类实现。
     * 4具体观察者角色：该角色实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题的状态相协调。
     * 通常用一个子类实现。如果需要，具体观察者角色可以保存一个指向具体主题角色的引用。
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Caller.create(new Caller.OnCall<String>() {

            @Override
            public void call(Receiver<String> stringReceiver) {
                if (!stringReceiver.isUnCalled()) {
                    stringReceiver.onNext("1");
                    stringReceiver.onNext("2");
                    stringReceiver.onCompleted();
                }

            }
        }).map(new Fun1<String, Integer>() {
        @Override
            public Integer call(String s) {
                return Integer.parseInt(s);
            }
        }).call(new Receiver<Integer>() {
            @Override
            public void onCompleted() {
                Log.e("MainActivity","onCompleted");

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onNext(Integer s) {

                Log.e("MainActivity",s+"");

            }
        });




    }
}

//
//        Observable.create(new Observable.OnSubscribe<String>() {
//
//
//            @Override
//            public void call(Subscriber<String> stringSubscribe) {
//
//                stringSubscribe.onNext("2233");
//
//                stringSubscribe.onCompleted();
//            }
//        }).subscribe(new Subscriber<String>() {
//
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable t) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//
//            }
//        });

//        Caller.create(new Caller.OnCall<String>() {
//            @Override
//            public void call(Receiver<String> stringReceiver) {
//
//                stringReceiver.onNext("2233");
////
//                stringReceiver.onCompleted();
//
//            }
//        }).call(new Receiver<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable t) {
//
//
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.e("TAG",s);
//
//            }
//        });

