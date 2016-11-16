package com.tianxi.mystudy.rxandroid;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by admin on 16/10/18.
 */

public class HttpUtils {

    public static OkHttpClient mokhttpClient = new OkHttpClient();


    public static void getData(String url ,Callback callback) {

        Request.Builder mbuilder=new Request.Builder();
        Request  builder=mbuilder.url(url).get().build();

        mokhttpClient.newCall(builder).enqueue(callback);

//        HttpUtils.threadMethod().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.e("自定义标签", "类名==MainActivity()" + "方法名==call()=="+Thread.currentThread().getName());
//            }
//        });
    }

    public static Observable<String> threadMethod() {
        Observable<String> observable=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                //假如这里要执行耗时操作,应该放到子线程,RxAndroid 提供了一个切换线程的方法
                Log.e("自定义标签", "类名==HttpUtils()" + "方法名==call()="+Thread.currentThread().getName());
                subscriber.onNext("这是测试线程用的");
            }
        });
        return observable;

    }

//    Callback() {
//        @Override
//        public void onFailure(Call call, IOException e) {
//
//
//        }
//
//        @Override
//        public void onResponse(Call call, Response response) throws IOException {
//            //这里得到数据
//
//            Log.d("HttpUtils", response.body().toString());
//        }
//
//    }


//    public  static void jsonRequest(String url){
//        Observable<String>
//
//    }

    public static Observable<MeiTianBean> jsonRequest(String url, Class clzz) {
        Observable<MeiTianBean> myBaseJsonObservable = Observable.create(new Observable.OnSubscribe<MeiTianBean>() {
            @Override
            public void call(Subscriber<? super MeiTianBean> subscriber) {
                Log.e("自定义标签", "类名==HttpUtils()" + "方法名==call()"+Thread.currentThread().getName());
                //获取数据并且发射数据
                Request.Builder mBuilder = new Request.Builder();
                Request build = mBuilder.url(url).get().build();
                mokhttpClient.newCall(build).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    /**
                     * 这个方法在子线程
                     * @param call
                     * @param response
                     * @throws IOException
                     */
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        //获取网络数据
                        String json = response.body().string();
                        MeiTianBean myBaseJson = (MeiTianBean) new Gson().fromJson(json, clzz);
                        subscriber.onNext(myBaseJson);
                    }
                });
            }
        });
        return myBaseJsonObservable;
    }

}
