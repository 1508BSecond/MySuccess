package com.pc.myapp.jx.apiServece;

import com.pc.myapp.jx.bean.JxBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by Helloworld on 2017/12/14.
 */

public interface ApiServece {

    /**
     *  /front/homePageApi/homePage.do
     */

    @GET("homePageApi/homePage.do")
    Flowable<JxBean> getHomeDate();

}
