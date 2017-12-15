package com.pc.myapp.specialfunction.presenter;

import com.pc.myapp.specialfunction.bean.SpecialBean;
import com.pc.myapp.specialfunction.model.SpecialModel;
import com.pc.myapp.specialfunction.utils.OnSuccessListener;
import com.pc.myapp.specialfunction.view.SpecialView;

/**
 * Created by TR on 2017/12/14.
 */

public class SpecialPresenter implements OnSuccessListener {

    private SpecialView specialView;
    private final SpecialModel specialModel;

    public SpecialPresenter(SpecialView specialView) {
        this.specialView = specialView;
        specialModel = new SpecialModel();
    }

    public void ralevence() {
        specialModel.getData(this);
    }

    @Override
    public void onSuccess(Object o) {
        specialView.SpecialData((SpecialBean) o);
    }
}
