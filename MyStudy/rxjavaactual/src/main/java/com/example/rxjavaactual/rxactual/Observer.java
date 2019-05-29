package com.example.rxjavaactual.rxactual;

/**
 * @author 甘罗
 * @date 18/1/8.
 */

public interface Observer<T> {


    void onCompleted();


    void onError(Throwable  t);


    void onNext(T t);




}
