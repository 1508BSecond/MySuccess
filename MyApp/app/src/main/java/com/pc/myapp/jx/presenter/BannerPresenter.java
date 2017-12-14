package com.pc.myapp.jx.presenter;

import com.pc.myapp.jx.bean.JxBean;
import com.pc.myapp.jx.model.BannerModel;
import com.pc.myapp.jx.success.BannerSuccessLisetner;
import com.pc.myapp.jx.view.BannerViewLisetner;

import javax.inject.Inject;

/**
 * Created by Helloworld on 2017/12/14.
 */

public class BannerPresenter implements BannerSuccessLisetner{


    BannerViewLisetner bannerViewLisetner;

    @Inject
    BannerModel bannerModel;

    @Inject
    public BannerPresenter(BannerViewLisetner bannerViewLisetner){
        this.bannerViewLisetner = bannerViewLisetner;
    }

    public void relevance(){
        bannerModel.getNetDate(this);
    }

    @Override
    public void BannerSuccess(JxBean jxBean) {
        bannerViewLisetner.BannerView(jxBean);
    }
}
