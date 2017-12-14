package com.pc.myapp.jump;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pc.myapp.R;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mDetailBack;
    /**
     * 玩玩
     */
    private TextView mDetailTvName;
    private ImageView mDetailIvHaibao;
    /**
     * 评分
     */
    private TextView mDetailTvFen;
    /**
     * 评分
     */
    private TextView mDetailTvType;
    /**
     * 评分
     */
    private TextView mDetailTvAddress;
    /**
     * 评分
     */
    private TextView mDetailTvTime;
    /**
     * 播放
     */
    private Button mDetailTvPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");


    }

    private void initView() {
        mDetailBack = (ImageView) findViewById(R.id.detail_back);
        mDetailBack.setOnClickListener(this);
        mDetailTvName = (TextView) findViewById(R.id.detail_tv_name);
        mDetailIvHaibao = (ImageView) findViewById(R.id.detail_iv_haibao);
        mDetailTvFen = (TextView) findViewById(R.id.detail_tv_fen);
        mDetailTvType = (TextView) findViewById(R.id.detail_tv_type);
        mDetailTvAddress = (TextView) findViewById(R.id.detail_tv_address);
        mDetailTvTime = (TextView) findViewById(R.id.detail_tv_time);
        mDetailTvPlay = (Button) findViewById(R.id.detail_tv_play);
        mDetailTvPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.detail_back:
                finish();
                break;
            case R.id.detail_tv_play:
                break;
        }
    }
}
