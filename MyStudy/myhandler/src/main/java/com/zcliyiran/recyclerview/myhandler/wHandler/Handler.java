package com.zcliyiran.recyclerview.myhandler.wHandler;


/**
 * @author lyr
 * @date 2018/9/22.
 */
public class Handler {


    private Looper mLooper;
    private MessageQueue mQueue;

    public Handler() {
        mLooper = Looper.myLooper();
        mQueue = mLooper.mQueue;
    }

    public final void  sendMessage(Message msg) {

         msg.target = this;
         mQueue.enqueueMessage(msg);
    }


    public void handleMessage(Message msg) {


    }


    public final void disPatchMessage(Message msg) {


       handleMessage(msg);
    }
}
