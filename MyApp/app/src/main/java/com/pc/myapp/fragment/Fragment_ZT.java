package com.pc.myapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pc.myapp.R;
import com.pc.myapp.activity.SpecialListActivity;
import com.pc.myapp.specialfunction.adapter.SpecialRecyclerViewAdapter;
import com.pc.myapp.specialfunction.bean.SpecialBean;
import com.pc.myapp.specialfunction.presenter.SpecialPresenter;
import com.pc.myapp.specialfunction.view.SpecialView;
import com.pc.myapp.utils.RecycleViewDivider;

import java.util.List;


/**
 * Created by pc on 2017/12/13.
 */

public class Fragment_ZT extends Fragment implements SpecialView {

    private View view;
    private RecyclerView mMyRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_zt, container, false);

        SpecialPresenter specialPresenter = new SpecialPresenter(this);
        specialPresenter.ralevence();
        initView(view);
        return view;
    }

    @Override
    public void SpecialData(SpecialBean specialBean) {
        List<SpecialBean.RetBean.ListBean> list = specialBean.getRet().getList();
        SpecialRecyclerViewAdapter specialRecyclerViewAdapter = new SpecialRecyclerViewAdapter(list, getActivity());
        mMyRecyclerView.setAdapter(specialRecyclerViewAdapter);
        specialRecyclerViewAdapter.setOnItemClickListener(new SpecialRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SpecialBean.RetBean.ListBean listBean, int position) {
                Intent intent = new Intent(getActivity(), SpecialListActivity.class);
                String moreURL = listBean.getMoreURL();
                intent.putExtra("moreURL",moreURL);
                getActivity().startActivity(intent);
            }
        });

    }

    private void initView(View view) {
        mMyRecyclerView = (RecyclerView) view.findViewById(R.id.myRecyclerView);
        mMyRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        RecycleViewDivider recycleViewDivider = new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL);
        mMyRecyclerView.addItemDecoration(recycleViewDivider);
    }
}
