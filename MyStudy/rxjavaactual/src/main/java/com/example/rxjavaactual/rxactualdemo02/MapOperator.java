package com.example.rxjavaactual.rxactualdemo02;

/**
 * @author 甘罗
 * @date 18/1/9.
 */

public class MapOperator<T,R> implements Caller.Operator<R,T> {
    private final Fun1<T,R>mapper;


    public MapOperator(Fun1<T, R> mapper) {
        this.mapper = mapper;
    }


    @Override
    public Receiver<T> call(Receiver<R> rReceiver) {


        return new MapReceiver<>(rReceiver,this.mapper);
    }
}
