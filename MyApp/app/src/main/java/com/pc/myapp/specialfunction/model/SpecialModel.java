package com.pc.myapp.specialfunction.model;

import com.pc.myapp.specialfunction.api.Api;
import com.pc.myapp.specialfunction.inter.ApiService;
import com.pc.myapp.specialfunction.bean.SpecialBean;
import com.pc.myapp.specialfunction.utils.OnSuccessListener;
import com.pc.myapp.utils.RetrofitUtils;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by TR on 2017/12/14.
 */

public class SpecialModel  {

    public void getData(final OnSuccessListener onSuccessListener) {

        ApiService apiService = RetrofitUtils.getInstance().getApiService(Api.zhuanti, ApiService.class);
        Flowable<SpecialBean> specialData = apiService.getSpecialData();
        specialData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<SpecialBean>() {
                    @Override
                    public void onNext(SpecialBean specialBean) {
                        onSuccessListener.onSuccess(specialBean);
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
