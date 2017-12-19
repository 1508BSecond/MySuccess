package com.pc.myapp.FX.component;

import com.pc.myapp.FX.module.FXModule;
import com.pc.myapp.fragment.Fragment_FX;

import dagger.Component;

/**
 * Created by wangziying on 2017/12/14.
 */

@Component(modules = FXModule.class)
public interface FXComponent {

    //注入调用者
    void inject(Fragment_FX fragment_fx);

}
