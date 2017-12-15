package com.pc.myapp.jx.presenter;

import com.pc.myapp.jx.bean.SeoBean;
import com.pc.myapp.jx.model.SeoModel;
import com.pc.myapp.jx.success.SeoSuccessLisetner;
import com.pc.myapp.jx.view.SeoViewLisetner;

import javax.inject.Inject;

/**
 * Created by Helloworld on 2017/12/15.
 */

public class SeoPresenter implements SeoSuccessLisetner{

    @Inject
    SeoModel seoModel;

    SeoViewLisetner seoViewLisetner;

    @Inject
    public SeoPresenter(SeoViewLisetner seoViewLisetner){
        this.seoViewLisetner = seoViewLisetner;
    }

    public void guanLian(String keyword, int pnum){
        seoModel.getSeoDate(this,keyword,pnum);
    }

    @Override
    public void seoSuccess(SeoBean seoBean) {
        seoViewLisetner.seoView(seoBean);
    }
}
