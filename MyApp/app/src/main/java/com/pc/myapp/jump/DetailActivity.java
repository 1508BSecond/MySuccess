package com.pc.myapp.jump;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.pc.myapp.R;
import com.pc.myapp.jump.fragment.Fragment_JJ;
import com.pc.myapp.jump.fragment.Fragment_TJ;

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
    private PagerSlidingTabStrip mDetailPsts;
    private ViewPager mDetailVp;

    //滑动标题
    String[] titles = {"简介","推荐"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        //关联


        //设值下面的横向滑动
        mDetailVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }

            @Override
            public Fragment getItem(int position) {

                Fragment fragment = null;
                switch (position){
                    case 0:
                        fragment = new Fragment_JJ();
                        break;
                    case 1:
                        fragment = new Fragment_TJ();
                        break;
                }

                return fragment;
            }

            @Override
            public int getCount() {
                return titles.length;
            }
        });
        mDetailPsts.setViewPager(mDetailVp);

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
        mDetailPsts = (PagerSlidingTabStrip) findViewById(R.id.detail_psts);
        mDetailVp = (ViewPager) findViewById(R.id.detail_vp);
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
