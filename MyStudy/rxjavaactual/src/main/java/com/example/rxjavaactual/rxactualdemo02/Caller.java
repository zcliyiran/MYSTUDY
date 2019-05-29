package com.example.rxjavaactual.rxactualdemo02;

/**
 * @author 甘罗
 * @date 18/1/8.
 */

public class Caller<T>{

    final OnCall<T> onCall;


    public Caller(OnCall<T> onCall){this.onCall=onCall;}


    public static <T> Caller<T> create( OnCall<T> onCall) {

        return  new Caller<>(onCall);

    }

    public Calling call(Receiver<T> receiver){
        this.onCall.call(receiver);
        return receiver;
    }

    public  interface  OnCall<T> extends Action1<Receiver<T>> {

    }

    public  interface  Operator<R,T>  extends Fun1<Receiver<R>,Receiver<T>>{


    }

    public final <R> Caller<R> lift(final Operator<R,T> operator){

        return  create(new OnCallLift<>(onCall,operator));

    }

    public  final <R> Caller<R> map(Fun1<T,R> func){
        return lift(new MapOperator<>(func));
    }

}
