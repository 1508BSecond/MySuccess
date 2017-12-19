package com.pc.myapp.FX.FXutils;

import com.pc.myapp.jx.bean.JxBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by wangziying on 2017/12/14.
 */

public interface ApiServer {

    /*
    * http://api.svipmovie.com/front/homePageApi/homePage.do
    * http://api.svipmovie.com/front/columns/getVideoList.do?catalogId=402834815584e463015584e539330016&pnum=10
    * get请求
    */

    @GET("homePageApi/homePage.do")
    Flowable<JxBean> getfx();
}
