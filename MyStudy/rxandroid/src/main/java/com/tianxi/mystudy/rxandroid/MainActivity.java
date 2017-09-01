package com.tianxi.mystudy.rxandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * rxandroid本身就是基于观察者模式的
 * 观察者,被观察者 订阅的方式取得联系
 */
public class MainActivity extends AppCompatActivity {
    private final String URL1 = "http://api.meitianapp.com/api/v1/articles?filter=isHomepage&start=%d&limit=20";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
//                HttpUtils.getData(URL1);
            }
        }).start();

//        action1();
//        subscriber();
//        observer();
//        range();
//        just();
//        defer();
//        from();
//        interval();
//        repeat();
//      flatMap();
//        cast();

        HttpUtils.threadMethod().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e("自定义标签", "类名==MainActivity()" + "方法名==call()=="+Thread.currentThread().getName());
            }
        });
    }

    private void cast() {//直接类型的转换,和 map 的区别是, map是通过某种方式将一种类型转成另外一种类型,而 cast则是通过 java
        //的强制类型转换变成对应的类型
        Guannchazhe guanChaZhe = new G1();
        Observable.just(guanChaZhe).cast(G1.class).subscribe(new Action1<G1>() {
            @Override
            public void call(G1 g1) {
                g1.change();
            }
        });
    }
    private void map() {
        Observable.just(1, 2, 3, 4).map(integer -> integer + "字符串").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e("自定义标签", "call() called with: " + "s = [" + s + "]");
            }
        });
    }
    private void flatMapIterable() {//转换为可以迭代的数据,转换后数据会重复执行多次
        Func1<Integer, List<Integer>> func1 = new Func1<Integer, List<Integer>>() {//泛型1 为原始类型,泛型2为转换后的类型
            ArrayList<Integer> arrayList = new ArrayList<>();

            @Override
            public List<Integer> call(Integer integer) {
                arrayList.add(integer);
                return arrayList;
            }
        };

        Observable<Integer> observable = (Observable<Integer>) Observable.just(1, 2, 3, 4, 5, 6).flatMapIterable(func1).subscribe(integer -> Log.e("自定义标签", "类名==MainActivity" + "方法名==flatMapIterable=====:" + integer));

    }
    private void flatMap() {//可以进行类型转换
        Observable<Integer> observable = Observable.just(1, 2, 3, 4);
        Observable<String> observable1 = observable.flatMap(integer -> Observable.just("转换" + integer));
        observable1.subscribe(s->Log.e("MainActivity", "call() called with: " + "s = [" + s + "]"));
    }

    private void repeat() {//有限循环,将制定的内容循环发送指定的次数
        Observable.just(1, 2, 3, 4).repeat(10).subscribe(integer -> Log.e("MainActivity", "类名==MainActivity" + "方法名==repeat=====:" + integer));

    }


    private void interval() {//对外发送数字, 每个多久发送一次,无限循环
        Observable.interval(3, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {

                Log.e("自定义标签", "类名==MainActivity" + "方法名==call=====:" + aLong);
            }
        });
    }

    private void from() {//从数组或集合中发送
//        String[] strings=new String[]{"1","2"};
        List<G1> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            G1 g = new G1();
            strings.add(g);
        }
        Observable.from(strings).subscribe(integer -> integer.change());


    }


    private void just() {//将 just里面的参数一个一个拿出来之后对外发射, just 内部可以是数字 字符串等任意内容
        Observable<String> o = Observable.just("122113e", "3323", "33e32", "3232", "3e23");
        o.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e("MainActivity", "call() called with: " + "s = [" + s + "]");

            }
        });


    }

    private void range() {//从 start开始,执行 count次循环,发送出去的数据也是从 start 开始,依次增加 count   lambda 表达式
        Observable<Integer> observable = Observable.range(5, 5);
//        observable.subscribe(integer-> Log.e("MainActivity", "类名==MainActivity" + "方法名==range=====:" + integer));
        observable.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.e("MainActivity", "类名==MainActivity" + "方法名==range=====:" + integer);
            }
        });


    }
    private void defer() {
        Func0 func = new Func0() {
            @Override
            public Object call() {
                return "dewde";
            }
        };
        Observable.defer(() -> Observable.just("1", "2", "3", "4"))
                .subscribe(integer -> Log.e("MainActivity", "call() called with: " + "s = [" + integer + "]")
                );


    }

    private void action1() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("action1的方式触发了");
            }
        });
        observable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e("MainActivity", "call() called with: " + "s = [" + s + "]");
            }
        });
    }

    private void subscriber() {
        Observable<String> mObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {//参数就是订阅者
                //被观察的数据发生变化的时候发射
                if (!subscriber.isUnsubscribed()) {//如果仍处于订阅状态,才会通知观察者
                    subscriber.onNext("数据发生变化了");
                }
            }
        });
        mObservable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String o) {
                Log.e("MainActivity", "onNext() called with:subscriber " + "o = [" + o + "]");
            }
        });
    }

    private void observer() {
        Observable<String> mObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {//参数就是订阅者
                //被观察的数据发生变化的时候发射
                if (!subscriber.isUnsubscribed()) {//如果仍处于订阅状态,才会通知观察者
                    subscriber.onNext("数据发生变化了");
                }
            }
        });
        mObservable.subscribe(new Observer<String>() {//建立订阅
            @Override
            public void onCompleted() {//完成

            }

            @Override
            public void onError(Throwable e) {//出现错误

            }

            @Override
            public void onNext(String o) {//正在执行
                Log.e("MainActivity", "onNext() called with: " + "o = [" + o + "]");
            }
        });
    }




}
