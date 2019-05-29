package com.example.rxjavaactual.rxactualdemo;

/**
 * @author 甘罗
 * @date 18/1/8.
 */

public interface Callee<T> {


    void onCompleted();


    void onError(Throwable t);


    void onNext(T t);




}
