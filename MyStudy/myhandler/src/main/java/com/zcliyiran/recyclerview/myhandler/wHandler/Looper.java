package com.zcliyiran.recyclerview.myhandler.wHandler;

/**
 * @author lyr
 * @date 2018/9/22.
 */
public class Looper {


    MessageQueue mQueue;
    //线程隔离数据
    public static final  ThreadLocal<Looper> sThreadLocal=new ThreadLocal<>();


    private Looper() {
        mQueue=new MessageQueue();

    }


    public static void prepare(){

        if (sThreadLocal .get()!= null) {

            throw new RuntimeException("Only one Looper may be created per thread");
        }

        sThreadLocal.set(new Looper());
    }


    public static  Looper myLooper (){

        return sThreadLocal.get();

    }


    public static void loop(){

       Looper me=Looper.myLooper();
        if (me == null) {
            throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
        }

        MessageQueue queue=me.mQueue;

        for (;  ; ) {
            Message msg=queue.next();
            if (msg == null) {
                continue;
            }
            msg.target.disPatchMessage(msg);

        }
    }



}
