package com.example.rxjavacourse;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * @author admin
 */
public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        testDemo01();
    }

    private void testDemo01() {


//        Subscription mySubscription= Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("ss");
//                subscriber.onCompleted();
//
//            }
//        }).subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//
//            }
//        });

//        Flowable flowable=
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {

            }
        }, BackpressureStrategy.DROP)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {


                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });








//
//        Subscription mySubscription = Observable.
//                create(new Observable.OnSubscribe<String>() {
//
//                    @Override
//                    public void call(Subscriber<? super String> subscriber) {
//                        subscriber.onNext("test");
//                        subscriber.onCompleted();
//                    }
//                })
////                .map(new Func1<String, String>() {
////                    @Override
////                    public String call(String s) {
////                        return s;
////                    }
////                })
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("onNext:" + s);
//                    }
//                });

    }


    private void testDemo02() {
//        Observable.create(new ObservableOnSubscribe<String>() {
//
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                if (!e.isDisposed()){
//                    e.onNext("test");
//                    e.onComplete();
//                }
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.e(TAG,"Subscription1");
//
//            }
//
//            @Override
//            public void onNext(String value) {
//              Log.e(TAG,"onNext1");
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//
//            }
//
//            @Override
//            public void onComplete() {
//
//                Log.e(TAG,"onComplete1");
//
//            }
//        });
//
//        Flowable.create(new FlowableOnSubscribe<String>() {
//
//            @Override
//            public void subscribe(FlowableEmitter<String> e) throws Exception {
//                if (!e.isCancelled()) {
//                    e.onNext("test");
//                    e.onComplete();
//
//                }
//
//            }
//        }, BackpressureStrategy.DROP)
//                .subscribe(new Subscriber<String>() {
//                               @Override
//                               public void onSubscribe(Subscription s) {
//                                   //响应式拉取
//                                   s.request(Long.MAX_VALUE);
//                                   Log.e(TAG, "Subscription");
//                               }
//
//                               @Override
//                               public void onNext(String s) {
//                                   Log.e(TAG, "onNext");
//                               }
//
//                               @Override
//                               public void onError(Throwable t) {
//
//                               }
//
//                               @Override
//                               public void onComplete() {
//                                   Log.e(TAG, "onComplete");
//                               }
//                           }
//                );
    }

}
