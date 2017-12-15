package com.pc.myapp.jx.component;

import com.pc.myapp.jx.SeoActivity;
import com.pc.myapp.jx.module.SeoModule;

import dagger.Component;

/**
 * Created by Helloworld on 2017/12/15.
 */
@Component(modules = SeoModule.class)
public interface SeoComponent {
    void inject(SeoActivity seoActivity);
}
