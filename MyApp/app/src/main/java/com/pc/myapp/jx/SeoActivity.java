package com.pc.myapp.jx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.pc.myapp.R;
import com.pc.myapp.jx.bean.SeoBean;
import com.pc.myapp.jx.component.DaggerSeoComponent;
import com.pc.myapp.jx.module.SeoModule;
import com.pc.myapp.jx.presenter.SeoPresenter;
import com.pc.myapp.jx.view.SeoViewLisetner;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seo);

        seo_bt = (Button) findViewById(R.id.seo_bt);
        seo_et = (EditText) findViewById(R.id.seo_et);
        seo_iv = (ImageView) findViewById(R.id.seo_iv);
        seo_rlv = (RecyclerView) findViewById(R.id.seo_rlv);
        seo_rlv.setLayoutManager(new LinearLayoutManager(this));
        name = seo_et.getText().toString().trim();
        DaggerSeoComponent.builder().seoModule(new SeoModule(this)).build().inject(this);



        seo_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seoPresenter.guanLian(name,pnum);
            }
        });

    }

    @Override
    public void seoView(SeoBean seoBean) {
        String code = seoBean.getCode();
        Toast.makeText(this, ""+code, Toast.LENGTH_SHORT).show();
    }

}
