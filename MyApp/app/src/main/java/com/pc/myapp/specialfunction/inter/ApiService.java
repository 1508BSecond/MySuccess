package com.pc.myapp.specialfunction.inter;

import com.pc.myapp.specialfunction.bean.ListDtBean;
import com.pc.myapp.specialfunction.bean.SpecialBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

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
     * @Query("catalogId") String catalogId, @Query("information") String information
     *  @param catalogId
     *  @param information
     *  @return
     */
    @GET("getVideoList.do")
    Flowable<ListDtBean> getListData(@Query("catalogId")String catalogId,@Query("information")String information);
}
