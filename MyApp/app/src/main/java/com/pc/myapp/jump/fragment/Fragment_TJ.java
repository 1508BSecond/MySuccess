package com.pc.myapp.jump.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pc.myapp.R;
import com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3.DaggerDetailCommpent;
import com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3.DetailModule;
import com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3.DetailPres;
import com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3.DetailView;
import com.pc.myapp.jump.adapter.FragTjAdapter;
import com.pc.myapp.jump.bean.DetailBean;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pc on 2017/12/14.
 */

public class Fragment_TJ extends Fragment implements DetailView {
    private View view;
    private RecyclerView mFragTiRlv;

    //注入对象
    @Inject
    DetailPres detailPres;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tj, container, false);
        initView(view);

        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");

        //得到桥梁对象
        DaggerDetailCommpent.builder().detailModule(new DetailModule(this)).build().injectTj(this);
        //关联
        detailPres.detailMandV(id);

        return view;
    }

    private void initView(View view) {
        mFragTiRlv = (RecyclerView) view.findViewById(R.id.frag_ti_rlv);
    }

    @Override
    public void detailShow(DetailBean detailBean) {

        List<DetailBean.RetBean.ListBean.ChildListBean> childList = detailBean.getRet().getList().get(0).getChildList();

        mFragTiRlv.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mFragTiRlv.setAdapter(new FragTjAdapter(getActivity(),childList));

    }
}
