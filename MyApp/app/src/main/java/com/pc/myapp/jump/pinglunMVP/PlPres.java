package com.pc.myapp.jump.pinglunMVP;

import com.pc.myapp.jump.bean.PlInfoBean;

import javax.inject.Inject;

/**
 * Created by pc on 2017/12/15.
 */

public class PlPres {

    @Inject
    PlModel plModel;

    private PlView plView;

    @Inject
    public PlPres(PlView plView) {
        this.plView = plView;
    }

    public void plMandV(String id){
        plModel.getplData(id, new OnPlListener() {
            @Override
            public void onSuccess(PlInfoBean plInfoBean) {
                plView.plShow(plInfoBean);
            }
        });
    }

}
