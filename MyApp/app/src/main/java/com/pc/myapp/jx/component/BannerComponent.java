package com.pc.myapp.jx.component;

import com.pc.myapp.fragment.Fragment_JX;
import com.pc.myapp.jx.module.BannerModule;

import dagger.Component;

/**
 * Created by Helloworld on 2017/12/14.
 */


@Component(modules = BannerModule.class)
public interface BannerComponent {
    void inject(Fragment_JX fragment_jx);
}
