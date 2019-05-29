package com.example.rxjavaactual.rxactual;

/**
 * @author 甘罗
 * @date 18/1/8.
 */

public class Observable <T>{

    final OnSubscribe<T> onCall;


    public Observable(OnSubscribe<T> onCall){

        this.onCall=onCall;
    }


    public static <T> Observable<T> create(OnSubscribe<T> onCall) {

        return  new Observable<>(onCall);

    }


    public Subscription subscribe(Subscriber<T> subscribe){

        this.onCall.call(subscribe);


        return subscribe;
    }

    public  interface  OnSubscribe<T> extends Action1<Subscriber<T>>{


    }
}
