package com.zcliyiran.recyclerview.myhandler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zcliyiran.recyclerview.myhandler.wHandler.Looper;

/**
 * 手写handler
 */
public class MainActivity extends AppCompatActivity {

//    private Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            Log.e("TAG1",msg.what+"");
//
//
//        }
//    };
//
//
//
//    private Handler handler2=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//
//
//            Log.e("TAG2",msg.what+"");
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//        handler.sendEmptyMessage(0);
//        handler.sendEmptyMessage(0);

//        handler2.sendEmptyMessage(1);

        Looper.prepare();
        final com.zcliyiran.recyclerview.myhandler.wHandler.Handler  myHandler=new com.zcliyiran.recyclerview.myhandler.wHandler.Handler(){

            @Override
            public void handleMessage(com.zcliyiran.recyclerview.myhandler.wHandler.Message msg) {
                super.handleMessage(msg);

                Log.e("TAG","handler"+Thread.currentThread().getName()+"msg"+msg.toString());
            }
        };


        for (int i = 0; i <10 ; i++) {


            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        com.zcliyiran.recyclerview.myhandler.wHandler.Message message=new com.zcliyiran.recyclerview.myhandler.wHandler.Message();
                        message.what=1;
                        message.obj="111111"+ finalI +"";
                        myHandler.sendMessage(message);
                        Thread.sleep(1000);
                        Log.e("TAG","send="+Thread.currentThread().getName()+"msg"+message.toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }

        Looper.loop();
    }
}
