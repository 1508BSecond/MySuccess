package com.pc.myapp.jump.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pc.myapp.R;
import com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3.DaggerDetailCommpent;
import com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3.DetailModule;
import com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3.DetailPres;
import com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3.DetailView;
import com.pc.myapp.jump.bean.DetailBean;

import javax.inject.Inject;

/**
 * Created by pc on 2017/12/14.
 */

public class Fragment_JJ extends Fragment implements DetailView {
    private View view;
    private TextView mFragJjDao;
    private TextView mFragJjType;
    private TextView mFragJjDes;

    //注入对象
    @Inject
    DetailPres detailPres;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_jj, container, false);
        initView(view);

        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");

        //得到桥梁对象
        DaggerDetailCommpent.builder().detailModule(new DetailModule(this)).build().injectJj(this);
        //关联
        detailPres.detailMandV(id);

        return view;
    }

    private void initView(View view) {
        mFragJjDao = (TextView) view.findViewById(R.id.frag_jj_dao);
        mFragJjType = (TextView) view.findViewById(R.id.frag_jj_type);
        mFragJjDes = (TextView) view.findViewById(R.id.frag_jj_des);
    }

    @Override
    public void detailShow(DetailBean detailBean) {
        //导演
        String director = detailBean.getRet().getDirector();
        //类型
        String videoType = detailBean.getRet().getVideoType();
        //简介
        String description = detailBean.getRet().getDescription();

        mFragJjDao.setText(director);
        mFragJjType.setText(videoType);
        mFragJjDes.setText(description);

    }
}
