package com.pc.myapp.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.hjm.bottomtabbar.BottomTabBar;
import com.pc.myapp.R;
import com.pc.myapp.fragment.Fragment_FX;
import com.pc.myapp.fragment.Fragment_JX;
import com.pc.myapp.fragment.Fragment_WD;
import com.pc.myapp.fragment.Fragment_ZT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomTabBar mMainBtb;
    private ImageView mAvatar;
    /**
     * 微影，微一下
     */
    private TextView mDesc;
    private LinearLayout mTopMenu;
    /**
     * 我的收藏
     */
    private TextView mTvCollect;
    /**
     * 我的下载
     */
    private TextView mTvMydown;
    /**
     * 福利
     */
    private TextView mTvFuli;
    /**
     * 分享
     */
    private TextView mTvShare;
    /**
     * 建议反馈
     */
    private TextView mTvFeedback;
    /**
     * 设置
     */
    private TextView mTvSetting;
    private ScrollView mScrollView;
    /**
     * 关于
     */
    private TextView mAbout;
    /**
     * 主题
     */
    private TextView mTheme;
    private LinearLayout mBottomMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mMainBtb.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(15)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("精选", R.mipmap.found, Fragment_JX.class)
                .addTabItem("专题", R.mipmap.special, Fragment_ZT.class)
                .addTabItem("发现", R.mipmap.fancy, Fragment_FX.class)
                .addTabItem("我的", R.mipmap.my, Fragment_WD.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });

    }

    private void initView() {
        mMainBtb = (BottomTabBar) findViewById(R.id.main_btb);
        mAvatar = (ImageView) findViewById(R.id.avatar);
        mAvatar.setOnClickListener(this);
        mDesc = (TextView) findViewById(R.id.desc);
        mDesc.setOnClickListener(this);
        mTopMenu = (LinearLayout) findViewById(R.id.top_menu);
        mTopMenu.setOnClickListener(this);
        mTvCollect = (TextView) findViewById(R.id.tv_collect);
        mTvCollect.setOnClickListener(this);
        mTvMydown = (TextView) findViewById(R.id.tv_mydown);
        mTvMydown.setOnClickListener(this);
        mTvFuli = (TextView) findViewById(R.id.tv_fuli);
        mTvFuli.setOnClickListener(this);
        mTvShare = (TextView) findViewById(R.id.tv_share);
        mTvShare.setOnClickListener(this);
        mTvFeedback = (TextView) findViewById(R.id.tv_feedback);
        mTvFeedback.setOnClickListener(this);
        mTvSetting = (TextView) findViewById(R.id.tv_setting);
        mTvSetting.setOnClickListener(this);
        mScrollView = (ScrollView) findViewById(R.id.scrollView);
        mScrollView.setOnClickListener(this);
        mAbout = (TextView) findViewById(R.id.about);
        mAbout.setOnClickListener(this);
        mTheme = (TextView) findViewById(R.id.theme);
        mTheme.setOnClickListener(this);
        mBottomMenu = (LinearLayout) findViewById(R.id.bottom_menu);
        mBottomMenu.setOnClickListener(this);
        mMainBtb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.avatar:
                break;
            case R.id.desc:
                break;
            case R.id.top_menu:
                break;
            case R.id.tv_collect:
                break;
            case R.id.tv_mydown:
                break;
            case R.id.tv_fuli:
                break;
            case R.id.tv_share:
                break;
            case R.id.tv_feedback:
                break;
            case R.id.tv_setting:
                break;
            case R.id.scrollView:
                break;
            case R.id.about:
                break;
            case R.id.theme:
                break;
            case R.id.bottom_menu:
                break;
            case R.id.main_btb:
                break;
        }
    }
}
