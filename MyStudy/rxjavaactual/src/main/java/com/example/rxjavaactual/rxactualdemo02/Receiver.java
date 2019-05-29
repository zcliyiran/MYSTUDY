package com.example.rxjavaactual.rxactualdemo02;

/**
 * @author 甘罗
 * @date 18/1/8.
 */

public abstract class Receiver<T> implements Calling, Callee<T> {


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
