package com.pc.myapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.pc.myapp.R;
import com.pc.myapp.jump.DetailActivity;
import com.pc.myapp.jx.SeoActivity;
import com.pc.myapp.jx.adapert.MyAdapert;
import com.pc.myapp.jx.api.GlideImageLoader;
import com.pc.myapp.jx.bean.JxBean;
import com.pc.myapp.jx.component.DaggerBannerComponent;
import com.pc.myapp.jx.module.BannerModule;
import com.pc.myapp.jx.presenter.BannerPresenter;
import com.pc.myapp.jx.view.BannerViewLisetner;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


/**
 * Created by pc on 2017/12/13.
 */

public class Fragment_JX extends Fragment implements BannerViewLisetner{

    @Inject
    BannerPresenter bannerPresenter;
    private Banner banner;
    private RecyclerView jx_rlv;
    private MyAdapert adapert;
    private ImageView jx_iv;
    private EditText jx_et;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_jx, container, false);
        banner = view.findViewById(R.id.banner);
        jx_rlv = view.findViewById(R.id.jx_rlv);
        jx_iv = view.findViewById(R.id.jx_iv);
        jx_et = view.findViewById(R.id.jx_et);
        jx_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SeoActivity.class);
                startActivity(intent);
            }
        });

        jx_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SeoActivity.class);
                startActivity(intent);
            }
        });

        DaggerBannerComponent.builder().bannerModule(new BannerModule(this)).build().inject(this);
        bannerPresenter.relevance();
        jx_rlv.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void BannerView(JxBean jxBean) {
        List<JxBean.RetBean.ListBean.ChildListBean> list = jxBean.getRet().getList().get(0).getChildList();
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        ArrayList<String> images = new ArrayList<>();
        for (int i = 0; i< list.size();i++){
            images.add(list.get(i).getPic());
        }
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        final List<JxBean.RetBean.ListBean.ChildListBean> childList = jxBean.getRet().getList().get(0).getChildList();
        adapert = new MyAdapert(getActivity(), childList);
        jx_rlv.setAdapter(adapert);

        adapert.setOnItemListener(new MyAdapert.OnItemListener() {
            @Override
            public void onItemClick(JxBean.RetBean.ListBean.ChildListBean childListBean) {
                String id = childListBean.getDataId();
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });


    }
}
