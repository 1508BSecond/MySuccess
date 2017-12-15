package com.pc.myapp.jx.model;

import com.pc.myapp.jx.api.Api;
import com.pc.myapp.jx.apiServece.ApiServece;
import com.pc.myapp.jx.bean.SeoBean;
import com.pc.myapp.jx.success.SeoSuccessLisetner;
import com.pc.myapp.utils.RetrofitUtils;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import retrofit2.Retrofit;

/**
 * Created by Helloworld on 2017/12/15.
 */

public class SeoModel {

    @Inject
    public SeoModel(){

    }

    public void getSeoDate(final SeoSuccessLisetner seoSuccessLisetner, String keyword, int pnum){

        Retrofit retrofit = RetrofitUtils.getRetrofit(Api.JX);
        ApiServece apiServece = retrofit.create(ApiServece.class);

        Flowable<SeoBean> flowable = apiServece.getSeoDate(keyword, pnum);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<SeoBean>() {
                    @Override
                    public void onNext(SeoBean seoBean) {
                        if (seoSuccessLisetner!=null){
                            seoSuccessLisetner.seoSuccess(seoBean);
                        }
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
