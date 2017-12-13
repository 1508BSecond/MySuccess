package com.pc.myapp.utils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pc on 2017/12/13.
 */

public class RetrofitUtils {

    private static RetrofitUtils retrofitUtils;
    public RetrofitUtils(){

    }

    //双重检验锁
    public static RetrofitUtils getInstance(){
        if(retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if(retrofitUtils==null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    //封装Retrofit
    private static Retrofit retrofit;

    public static synchronized Retrofit getRetrofit(String url){

        //添加ok的拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(url)
                    .build();
        }

        return retrofit;
    }

    //调用后返回网络接口对象
    public <T>T getApiService(String url,Class<T> clazz){
        Retrofit retrofit = getRetrofit(url);
        return retrofit.create(clazz);
    }



}
