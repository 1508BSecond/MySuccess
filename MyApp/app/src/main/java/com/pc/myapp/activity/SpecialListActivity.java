package com.pc.myapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.pc.myapp.R;
import com.pc.myapp.jump.DetailActivity;
import com.pc.myapp.specialfunction.adapter.SpecialListRecyclerViewAdapter;
import com.pc.myapp.specialfunction.bean.ListDtBean;
import com.pc.myapp.specialfunction.presenter.GetListPresenter;
import com.pc.myapp.specialfunction.view.GetListView;
import com.pc.myapp.utils.RecycleViewDivider;

import java.util.List;

public class SpecialListActivity extends AppCompatActivity implements GetListView, View.OnClickListener {

    private RecyclerView mListRecyclerView;
    private ImageView mListback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_list);
        initView();
        Intent intent = getIntent();
        String moreURL = intent.getStringExtra("moreURL");
        if (moreURL.equals("")) {
            Toast.makeText(this, "很遗憾,没有更多视频", Toast.LENGTH_SHORT);
        } else {
            GetListPresenter getListPresenter = new GetListPresenter(this);
            getListPresenter.ralevence();
        }
    }

    @Override
    public void getList(ListDtBean listDtBean) {
        List<ListDtBean.RetBean.ListBean> list = listDtBean.getRet().getList();
        SpecialListRecyclerViewAdapter adapter = new SpecialListRecyclerViewAdapter(list, this);
        mListRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new SpecialListRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListDtBean.RetBean.ListBean listBean, int position) {
                String dataId = listBean.getDataId();

                Intent intent = new Intent(SpecialListActivity.this, DetailActivity.class);
                Intent dataId1 = intent.putExtra("id", dataId);
                startActivity(dataId1);
            }

        });

    }

    private void initView() {
        mListRecyclerView = (RecyclerView) findViewById(R.id.ListRecyclerView);
        mListRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        RecycleViewDivider recycleViewDivider = new RecycleViewDivider(this, LinearLayoutManager.VERTICAL);
        mListRecyclerView.addItemDecoration(recycleViewDivider);
        mListback = (ImageView) findViewById(R.id.listback);
        mListback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.listback:
                this.finish();
                break;
        }
    }
}
