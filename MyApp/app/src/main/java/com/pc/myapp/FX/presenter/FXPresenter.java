package com.pc.myapp.FX.presenter;

import android.util.Log;

import com.pc.myapp.FX.OnnetListener.FXOnnetListener;
import com.pc.myapp.FX.model.FXModel;
import com.pc.myapp.FX.view.FXView;
import com.pc.myapp.jx.bean.JxBean;

import javax.inject.Inject;

/**
 * Created by wangziying on 2017/12/14.
 */

public class FXPresenter {
    @Inject
    FXModel model;

    FXView view;

    @Inject
    public FXPresenter(FXView view) {
        this.view = view;
    }

    public void getpresenter(){
        model.getmolde(new FXOnnetListener() {
            @Override
            public void onsunccess(JxBean bean) {
                view.getview(bean);
                Log.i("getview","getview");
            }
        });
    }
}
