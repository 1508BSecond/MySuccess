package com.pc.myapp.jump.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pc.myapp.R;
import com.pc.myapp.jump.adapter.FragPlAdapter;
import com.pc.myapp.jump.bean.PlInfoBean;
import com.pc.myapp.jump.pinglunMVP.DaggerPlComponent;
import com.pc.myapp.jump.pinglunMVP.PlModule;
import com.pc.myapp.jump.pinglunMVP.PlPres;
import com.pc.myapp.jump.pinglunMVP.PlView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pc on 2017/12/14.
 */

public class Fragment_PL extends Fragment implements PlView {
    private View view;

    //注入对象
    @Inject
    PlPres plPres;
    private RecyclerView mFragPlRlv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_pl, container, false);

        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");

        //得到桥梁对象
        DaggerPlComponent.builder().plModule(new PlModule(this)).build().inject(this);
        plPres.plMandV(id);

        initView(view);
        return view;
    }

    @Override
    public void plShow(PlInfoBean plInfoBean) {
        //String msg = plInfoBean.getRet().getList().get(0).getMsg();
        //Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        List<PlInfoBean.RetBean.ListBean> list = plInfoBean.getRet().getList();

        mFragPlRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mFragPlRlv.setAdapter(new FragPlAdapter(getActivity(),list));

    }

    private void initView(View view) {
        mFragPlRlv = (RecyclerView) view.findViewById(R.id.frag_pl_rlv);
    }
}
