package com.pc.myapp.specialfunction.presenter;

import com.pc.myapp.specialfunction.bean.ListDtBean;
import com.pc.myapp.specialfunction.model.GetListModel;
import com.pc.myapp.specialfunction.utils.OnSuccessListener;
import com.pc.myapp.specialfunction.view.GetListView;

/**
 * Created by TR on 2017/12/14.
 */

public class GetListPresenter implements OnSuccessListener{
    private GetListView getListView;
    private final GetListModel getListModel;

    public GetListPresenter(GetListView getListView) {
        this.getListView = getListView;
        getListModel = new GetListModel();

    }
    public void ralevence() {
        getListModel.getData(this);
    }


    @Override
    public void onSuccess(Object o) {
        getListView.getList((ListDtBean)o);
    }
}
