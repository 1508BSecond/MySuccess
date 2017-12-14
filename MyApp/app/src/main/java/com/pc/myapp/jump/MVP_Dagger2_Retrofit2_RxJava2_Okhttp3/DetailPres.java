package com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3;

import com.pc.myapp.jump.bean.DetailBean;

import javax.inject.Inject;

/**
 * Created by pc on 2017/12/14.
 */

public class DetailPres {

    @Inject
    DetailModel detailModel;

    DetailView detailView;

    @Inject
    public DetailPres(DetailView detailView) {
        this.detailView = detailView;
    }

    public void detailMandV(String mediaId){
        detailModel.detailData(mediaId, new OnDetailListener() {
            @Override
            public void onSuccess(DetailBean detailBean) {
                detailView.detailShow(detailBean);
            }
        });
    }

}
