package com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3;

import com.pc.myapp.jump.DetailActivity;
import com.pc.myapp.jump.PlayActivity;
import com.pc.myapp.jump.fragment.Fragment_JJ;

import dagger.Component;

/**
 * Created by pc on 2017/12/14.
 */


@Component(modules = DetailModule.class)
public interface DetailCommpent {

    void inject(DetailActivity detailActivity);
    void injectPlay(PlayActivity playActivity);
    void injectJj(Fragment_JJ fragment_jj);

}
