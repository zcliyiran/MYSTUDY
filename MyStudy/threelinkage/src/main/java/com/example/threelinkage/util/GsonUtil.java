package com.example.threelinkage.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 甘罗 on 17/8/26.
 */

public class GsonUtil {
    private static Gson mGson = new Gson();

    /**
     * 将json转化成实体对象
     */


    public  static Object stringToObject(String json, Class classOfT){

        return  mGson.fromJson(json ,classOfT ) ;
    }

    /**
     * 将对象转换成json字符串
     * 或者把list转化成json
     */
    public  static <T>  String objectToString(T object){
        return mGson.toJson(object);

    }


    /**
     * 将json 字符串转化成list
     *
     */
    public  static <T>List<T>stringToList(String json ,Class<T> cls ){
        Gson gson = new Gson();
        List<T> list = new ArrayList<>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for(final JsonElement elem : array){
            list.add(gson.fromJson(elem, cls));
        }
        return list ;
    }



}
