package com.pc.myapp.jump.pinglunMVP;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.pc.myapp.jump.API;
import com.pc.myapp.jump.ApiService;
import com.pc.myapp.jump.bean.PlInfoBean;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pc on 2017/12/15.
 */

public class PlModel {

    @Inject
    public PlModel() {
    }

    public void getplData(String mediaId, final OnPlListener onPlListener){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API.URL)
                .client(okHttpClient)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Flowable<PlInfoBean> flowable = apiService.plInfo(mediaId);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<PlInfoBean>() {
                    @Override
                    public void onNext(PlInfoBean plInfoBean) {
                        onPlListener.onSuccess(plInfoBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
