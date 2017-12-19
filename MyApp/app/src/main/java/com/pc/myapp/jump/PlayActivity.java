package com.pc.myapp.jump;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.pc.myapp.R;
import com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3.DaggerDetailCommpent;
import com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3.DetailModule;
import com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3.DetailPres;
import com.pc.myapp.jump.MVP_Dagger2_Retrofit2_RxJava2_Okhttp3.DetailView;
import com.pc.myapp.jump.bean.DetailBean;
import com.pc.myapp.jump.fragment.Fragment_JJ;
import com.pc.myapp.jump.fragment.Fragment_PL;

import javax.inject.Inject;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.widget.media.AndroidMediaController;
import tv.danmaku.ijk.media.widget.media.IjkVideoView;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener, DetailView {

    private ImageView mPlayBack;
    /**
     * 名字
     */
    private TextView mPlayTvName;
    private IjkVideoView mPlayIjk;
    private PagerSlidingTabStrip mPlayPsts;
    private ViewPager mPlayVp;

    //滑动标题
    String[] titles = {"简介","评论"};

    //注入对象
    @Inject
    DetailPres detailPres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        initView();

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        //关联
        //得到桥梁对象
        DaggerDetailCommpent.builder().detailModule(new DetailModule(this)).build().injectPlay(this);
        //关联
        detailPres.detailMandV(id);

        //横向滑动Fragment
        mPlayVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

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
                        fragment = new Fragment_PL();
                        break;
                }

                return fragment;
            }

            @Override
            public int getCount() {
                return titles.length;
            }
        });
        mPlayPsts.setViewPager(mPlayVp);

    }

    private void initView() {
        mPlayBack = (ImageView) findViewById(R.id.play_back);
        mPlayBack.setOnClickListener(this);
        mPlayTvName = (TextView) findViewById(R.id.play_tv_name);
        mPlayIjk = (IjkVideoView) findViewById(R.id.play_ijk);
        mPlayPsts = (PagerSlidingTabStrip) findViewById(R.id.play_psts);
        mPlayVp = (ViewPager) findViewById(R.id.play_vp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_back:
                finish();
                break;
        }
    }

    //实现View层
    @Override
    public void detailShow(DetailBean detailBean) {
        Toast.makeText(this, detailBean.getMsg(), Toast.LENGTH_SHORT).show();

        //设值标题name
        mPlayTvName.setText(detailBean.getRet().getTitle());

        //ijk播放
        AndroidMediaController controller = new AndroidMediaController(this, false);
        mPlayIjk.setMediaController(controller);
        //String url = "https://wdl.wallstreetcn.com/41aae4d2-390a-48ff-9230-ee865552e72d";
        // String url = "http://o6wf52jln.bkt.clouddn.com/演员.mp3";
        mPlayIjk.setVideoURI(Uri.parse(detailBean.getRet().getSmoothURL()));
        mPlayIjk.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayIjk.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        IjkMediaPlayer.native_profileEnd();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlayIjk.resume();
    }

}
