package com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3;

import com.pc.myapp.jump.DetailActivity;

import dagger.Component;

/**
 * Created by pc on 2017/12/14.
 */


@Component(modules = DetailModule.class)
public interface DetailCommpent {

    void inject(DetailActivity detailActivity);

}
