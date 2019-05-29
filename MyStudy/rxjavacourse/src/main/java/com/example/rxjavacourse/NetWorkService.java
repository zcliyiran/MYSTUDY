package com.example.rxjavacourse;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.lang.reflect.Type;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @author 甘罗
 * @date 18/1/18.
 */

public class NetWorkService {


    private NetWorkInterface myService;


    private NetWorkService() {


        GsonBuilder gsonBuilder = new GsonBuilder();

        Type type = new TypeToken<String>() {
        }.getType();

        final OkHttpClient client = new OkHttpClient();

        Gson gson = gsonBuilder.registerTypeAdapter(type, new StringDeserializer()).create();
        Retrofit rest = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client).baseUrl("").build();

    }


    private static class InstanceHolder {


        private static final NetWorkService instance = new NetWorkService();

    }

    public static NetWorkInterface getInsterface() {


        return InstanceHolder.instance.myService;
    }


    class StringDeserializer implements JsonDeserializer<String> {


        @Override
        public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            String result = null;
            if (json != null) {
                JsonObject obj = json.getAsJsonObject();
                if (obj != null) {
                    result = obj.toString();
                }
            }


            return result;
        }
    }

    public interface NetWorkInterface {


    }


    public static  final class NetworkTransformer<T>  implements ObservableTransformer<T, T> {


        @Override
        public ObservableSource<T> apply(Observable<T> upstream) {



            return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    }


}
