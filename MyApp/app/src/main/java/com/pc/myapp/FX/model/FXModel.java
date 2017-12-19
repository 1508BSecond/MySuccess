package com.pc.myapp.FX.model;

import android.util.Log;

import com.pc.myapp.FX.FXutils.Api;
import com.pc.myapp.FX.FXutils.ApiServer;
import com.pc.myapp.FX.OnnetListener.FXOnnetListener;
import com.pc.myapp.jx.bean.JxBean;
import com.pc.myapp.utils.RetrofitUtils;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by wangziying on 2017/12/14.
 */


public class FXModel {

    @Inject
    public FXModel(){

    };

    public void getmolde(final FXOnnetListener onnetListener){

        ApiServer apiService = RetrofitUtils.getInstance().getApiService(Api.fxurl, ApiServer.class);

        Flowable<JxBean> flowable = apiService.getfx();
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<JxBean>() {
                    @Override
                    public void onNext(JxBean jxBean) {
                        String msg = jxBean.getMsg();
                        Log.i("model",msg);
                        onnetListener.onsunccess(jxBean);
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
