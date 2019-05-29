package com.example.rxjavaactual.rxactual;

/**
 * @author 甘罗
 * @date 18/1/8.
 */

public abstract class Subscriber<T> implements Subscription, Observer<T> {


    private volatile boolean unCalled;

    @Override
    public void unCall() {

        unCalled = true;
    }


    @Override
    public boolean isUnCalled() {
        return unCalled;
    }
}
