package com.pc.myapp.jx.apiServece;

import com.pc.myapp.jx.bean.JxBean;
import com.pc.myapp.jx.bean.SeoBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Helloworld on 2017/12/14.
 */

public interface ApiServece {

    /**
     *  /front/homePageApi/homePage.do
     */

    @GET("homePageApi/homePage.do")
    Flowable<JxBean> getHomeDate();

    @GET("searchKeyWordApi/getVideoListByKeyWord.do")
    Flowable<SeoBean> getSeoDate(@Query("keyword")String keyword, @Query("pnum")int pnum);
}
