package com.pc.myapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mcxtzhang.layoutmanager.swipecard.CardConfig;
import com.mcxtzhang.layoutmanager.swipecard.OverLayCardLayoutManager;
import com.mcxtzhang.layoutmanager.swipecard.RenRenCallback;
import com.pc.myapp.FX.adapter.FXMyAdapter;
import com.pc.myapp.FX.component.DaggerFXComponent;
import com.pc.myapp.FX.module.FXModule;
import com.pc.myapp.FX.presenter.FXPresenter;
import com.pc.myapp.FX.view.FXView;
import com.pc.myapp.R;
import com.pc.myapp.jump.PlayActivity;
import com.pc.myapp.jx.bean.JxBean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


/**
 * Created by pc on 2017/12/13.
 */

public class Fragment_FX extends Fragment implements View.OnClickListener{

    private View view;
    private RecyclerView rlv;
    /**
     * 换一个
     */
    private Button but;
    private int pnum=0;
    private List<JxBean.RetBean.ListBean.ChildListBean> alist=new ArrayList<>();

    //注入对象
    @Inject
    FXPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_fx, container, false);

        //初始化ID
        initView(view);

        //得到桥梁对象
        DaggerFXComponent.builder().fXModule(new FXModule(new FXView() {
            @Override
            public void getview(JxBean bean) {
                List<JxBean.RetBean.ListBean.ChildListBean> list = bean.getRet().getList().get(pnum).getChildList();
                alist.addAll(list);

                FXMyAdapter adapter = new FXMyAdapter(alist, getActivity());

                //设置卡片滑动
                rlv.setLayoutManager(new OverLayCardLayoutManager());
                CardConfig.initConfig(getActivity());
                ItemTouchHelper.Callback callback = new RenRenCallback(rlv, adapter, alist);
                ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
                itemTouchHelper.attachToRecyclerView(rlv);

                rlv.setAdapter(adapter);

                //点击跳转到播放界面
                adapter.setOnItemListener(new FXMyAdapter.OnItemListener() {
                    @Override
                    public void OnCilck(JxBean.RetBean.ListBean.ChildListBean dataBean) {
                        String id = dataBean.getDataId();

                        Intent intent = new Intent(getActivity(), PlayActivity.class);
                        intent.putExtra("id",id);
                        startActivity(intent);
                    }
                });

            }
        })).build().inject(this);

        //关联
        presenter.getpresenter();
        return view;
    }

    private void initView(View view) {
        //初始化ID
        rlv = (RecyclerView) view.findViewById(R.id.rlv);
        but = (Button) view.findViewById(R.id.but);
        but.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but:
                //点击换一批
                pnum++;
                if(pnum>11){
                    pnum=0;
                }
                alist.clear();
                presenter.getpresenter();
                break;
        }
    }


  /*  @Override
    public void getview(FXBean bean) {
        String code = bean.getCode();

        if(code=="600"){
            Toast.makeText(getActivity(),"视频已下线",Toast.LENGTH_SHORT);
        }else if(code=="404"){
            Toast.makeText(getActivity(),"视频不存在",Toast.LENGTH_SHORT);
        }else{

            //得到集合
            List<FXBean.RetBean.ListBean> list = bean.getRet().getList();

            alist.addAll(list);


            //适配器
            FXMyAdapter adapter = new FXMyAdapter(alist, getActivity());


            //设置卡片滑动
            rlv.setLayoutManager(new OverLayCardLayoutManager());
            CardConfig.initConfig(getActivity());
            ItemTouchHelper.Callback callback = new RenRenCallback(rlv, adapter, alist);
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
            itemTouchHelper.attachToRecyclerView(rlv);


            adapter.setOnItemListener(new FXMyAdapter.OnItemListener() {
                @Override
                public void OnCilck(FXBean.RetBean.ListBean dataBean) {

                    String dataId = dataBean.getDataId();

                    Toast.makeText(getActivity(),dataId,Toast.LENGTH_SHORT);

                    Intent intent=new Intent(getActivity(), PlayActivity.class);
                    intent.putExtra("id",dataId);
                    startActivity(intent);
                }
            });

            //关联适配器
            rlv.setAdapter(adapter);
        }
    }*/
}
