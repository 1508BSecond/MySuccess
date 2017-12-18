package com.pc.myapp.jx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.pc.myapp.R;
import com.pc.myapp.jump.DetailActivity;
import com.pc.myapp.jx.adapert.MySeoAdapert;
import com.pc.myapp.jx.bean.SeoBean;
import com.pc.myapp.jx.component.DaggerSeoComponent;
import com.pc.myapp.jx.module.SeoModule;
import com.pc.myapp.jx.presenter.SeoPresenter;
import com.pc.myapp.jx.view.SeoViewLisetner;

import java.util.List;

import javax.inject.Inject;

public class SeoActivity extends AppCompatActivity implements SeoViewLisetner{

    @Inject
    SeoPresenter seoPresenter;

    private Button seo_bt;
    private EditText seo_et;
    private ImageView seo_iv;
    int pnum=1;
    private String name;
    private RecyclerView seo_rlv;
    private ImageView seo_iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seo);

        seo_bt = (Button) findViewById(R.id.seo_bt);
        seo_et = (EditText) findViewById(R.id.seo_et);
        seo_iv = (ImageView) findViewById(R.id.seo_iv);
        seo_rlv = (RecyclerView) findViewById(R.id.seo_rlv);
        seo_iv2 = (ImageView) findViewById(R.id.seo_iv2);







        DaggerSeoComponent.builder().seoModule(new SeoModule(this)).build().inject(this);

        seo_rlv.setLayoutManager(new GridLayoutManager(this,3));

        seo_iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        seo_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = seo_et.getText().toString().trim();
                seoPresenter.guanLian(name,pnum);
            }
        });

    }

    @Override
    public void seoView(SeoBean seoBean) {

        List<SeoBean.RetBean.ListBean> list = seoBean.getRet().getList();
        MySeoAdapert adapert = new MySeoAdapert(this, list);
        seo_rlv.setAdapter(adapert);
        adapert.setOnItemListener(new MySeoAdapert.OnItemListener() {
            @Override
            public void onItemClick(SeoBean.RetBean.ListBean listBean) {
                String id = listBean.getDataId();
                Intent intent = new Intent(SeoActivity.this, DetailActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }




}
