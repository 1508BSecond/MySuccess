package com.pc.myapp.specialfunction.model;

import android.util.Log;

import com.pc.myapp.specialfunction.api.Api;
import com.pc.myapp.specialfunction.inter.ApiService;
import com.pc.myapp.specialfunction.bean.ListDtBean;
import com.pc.myapp.specialfunction.utils.OnSuccessListener;
import com.pc.myapp.utils.RetrofitUtils;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by TR on 2017/12/14.
 */

public class GetListModel {

    public void getData(final OnSuccessListener onSuccessListener) {
        ApiService apiService = RetrofitUtils.getInstance().getApiService(Api.list, ApiService.class);

        Flowable<ListDtBean> list = apiService.getListData();
        list.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ListDtBean>() {
                    @Override
                    public void onNext(ListDtBean listDtBean) {
                        onSuccessListener.onSuccess(listDtBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.i("xxx",t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}