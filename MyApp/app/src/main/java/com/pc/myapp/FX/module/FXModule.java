package com.pc.myapp.FX.module;

import com.pc.myapp.FX.view.FXView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wangziying on 2017/12/14.
 */

@Module
public class FXModule {

    //实例化
    private FXView view;

    public FXModule(FXView view) {
        this.view = view;
    }

    @Provides
    FXView getView(){
        return view;
    }

}
