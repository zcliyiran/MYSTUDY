package com.zcliyiran.recyclerview.myhandler.wHandler;

/**
 * @author lyr
 * @date 2018/9/22.
 */
public class Message {


    public int what;

    public Object obj;

    Handler target;

    public Message() {


    }


    @Override
    public String toString() {
        return obj.toString();
    }
}
