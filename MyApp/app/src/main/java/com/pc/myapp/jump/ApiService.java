package com.pc.myapp.jump;

import com.pc.myapp.jump.bean.DetailBean;
import com.pc.myapp.jump.bean.PlInfoBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by pc on 2017/12/14.
 */

public interface ApiService {

    /**
     * 详情页
     * http://api.svipmovie.com/front/
     * videoDetailApi/videoDetail.do
     * ?mediaId=840ddae38ed346a197a76b46b448067e
     *
     */
    @GET("videoDetailApi/videoDetail.do")
    Flowable<DetailBean> detail(@Query("mediaId")String mediaId);

    /**
     * 评论
     * http://api.svipmovie.com/front/
     * Commentary/getCommentList.do
     * ?mediaId=840ddae38ed346a197a76b46b448067e
     *
     */
    @GET("Commentary/getCommentList.do")
    Flowable<PlInfoBean> plInfo(@Query("mediaId")String mediaId);

}
