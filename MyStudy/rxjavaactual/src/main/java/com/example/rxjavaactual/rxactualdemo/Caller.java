package com.example.rxjavaactual.rxactualdemo;

/**
 * @author 甘罗
 * @date 18/1/8.
 */

public class Caller<T>{

    final OnCall<T> onCall;


    public Caller(OnCall<T> onCall){

        this.onCall=onCall;
    }


    public static <T> Caller<T> create(OnCall<T> onCall) {

        return  new Caller<>(onCall);

    }


    public Calling call(Receiver<T> subscribe){

        this.onCall.call(subscribe);


        return subscribe;
    }

    public  interface  OnCall<T> extends Action1<Receiver<T>> {



    }
}
