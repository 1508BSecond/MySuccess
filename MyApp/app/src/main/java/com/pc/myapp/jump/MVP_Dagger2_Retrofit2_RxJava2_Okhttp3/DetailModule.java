package com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pc on 2017/12/14.
 */

@Module
public class DetailModule {
    //实例化
    private DetailView detailView;

    public DetailModule(DetailView detailView) {
        this.detailView = detailView;
    }

    @Provides
    DetailView providesDetail(){
        return detailView;
    }
}
