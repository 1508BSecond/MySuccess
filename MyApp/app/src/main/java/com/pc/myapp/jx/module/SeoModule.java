package com.pc.myapp.jx.module;

import com.pc.myapp.jx.view.SeoViewLisetner;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Helloworld on 2017/12/14.
 */

@Module
public class SeoModule {

    private SeoViewLisetner seoViewLisetner;

    public SeoModule(SeoViewLisetner seoViewLisetner){
        this.seoViewLisetner = seoViewLisetner;
    }

    @Provides
    SeoViewLisetner provideseoViewLisetner(){
        return seoViewLisetner;
    }

}
