package com.pc.myapp.jx.module;

import com.pc.myapp.jx.view.BannerViewLisetner;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Helloworld on 2017/12/14.
 */

@Module
public class BannerModule {

    private BannerViewLisetner bannerViewLisetner;

    public BannerModule(BannerViewLisetner bannerViewLisetner){
        this.bannerViewLisetner =bannerViewLisetner;
    }

    @Provides
    BannerViewLisetner providebannerViewLisetner(){
        return bannerViewLisetner;
    }

}
