package com.pc.myapp.jx.model;

import com.pc.myapp.jx.api.Api;
import com.pc.myapp.jx.apiServece.ApiServece;
import com.pc.myapp.jx.bean.JxBean;
import com.pc.myapp.jx.success.BannerSuccessLisetner;
import com.pc.myapp.utils.RetrofitUtils;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import retrofit2.Retrofit;

/**
 * Created by Helloworld on 2017/12/14.
 */

public class BannerModel {

    @Inject
    public BannerModel(){
    }

    public void getNetDate(final BannerSuccessLisetner bannerSuccessLisetner){

        Retrofit retrofit = RetrofitUtils.getRetrofit(Api.JX);
        ApiServece apiServece = retrofit.create(ApiServece.class);

        Flowable<JxBean> flowable = apiServece.getHomeDate();
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<JxBean>() {
                    @Override
                    public void onNext(JxBean jxBean) {
                        if (bannerSuccessLisetner!=null){
                            bannerSuccessLisetner.BannerSuccess(jxBean);
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
