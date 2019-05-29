package com.example.rxjavaactual.rxactualdemo02;

/**
 * @author 甘罗
 * @date 18/1/9.
 */

public class MapReceiver <T,R> extends Receiver<T> {

    private final Receiver<R> actual;
    private  final  Fun1<T,R> mapper;


    public MapReceiver(Receiver<R> actual, Fun1<T, R> mapper) {
        this.actual = actual;
        this.mapper = mapper;
    }

    @Override
    public void onCompleted() {
        this.actual.onCompleted();

    }

    @Override
    public void onError(Throwable t) {
        this.actual.onError(t);

    }

    @Override
    public void onNext(T t) {
         R tR=  this.mapper.call(t);
        this.actual.onNext(tR);

    }
}
