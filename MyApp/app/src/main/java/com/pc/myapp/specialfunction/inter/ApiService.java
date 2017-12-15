package com.pc.myapp.specialfunction.inter;

import com.pc.myapp.specialfunction.bean.ListDtBean;
import com.pc.myapp.specialfunction.bean.SpecialBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by TR on 2017/12/14.
 */

public interface ApiService {

    /**
     * @return
     */
    @GET("homePageApi/homePage.do")
    Flowable<SpecialBean> getSpecialData();


    /**
     * http://api.svipmovie.com/front/
     * columns/getNewsList.do
     * ?catalogId=402834815584e463015584e539700019&information=null
     * @Query("catalogId") String catalogId, @Query("information") String information
     *  @return
     */
    @GET("columns/getNewsList.do?catalogId=402834815584e463015584e539700019&information=null")
    Flowable<ListDtBean> getListData();
}
