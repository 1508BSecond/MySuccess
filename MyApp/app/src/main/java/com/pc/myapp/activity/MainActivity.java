package com.pc.myapp.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;
import com.pc.myapp.R;
import com.pc.myapp.fragment.Fragment_FX;
import com.pc.myapp.fragment.Fragment_JX;
import com.pc.myapp.fragment.Fragment_WD;
import com.pc.myapp.fragment.Fragment_ZT;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar mMainBtb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mMainBtb.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(15)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("精选",R.mipmap.found, Fragment_JX.class)
                .addTabItem("专题",R.mipmap.special, Fragment_ZT.class)
                .addTabItem("发现",R.mipmap.fancy, Fragment_FX.class)
                .addTabItem("我的",R.mipmap.my, Fragment_WD.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });

    }

    private void initView() {
        mMainBtb = (BottomTabBar) findViewById(R.id.main_btb);
    }
}
