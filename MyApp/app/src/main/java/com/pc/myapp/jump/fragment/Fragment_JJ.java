package com.pc.myapp.jump.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pc.myapp.R;

/**
 * Created by pc on 2017/12/14.
 */

public class Fragment_JJ extends Fragment {
    private View view;
    private TextView mFragJjDao;
    private TextView mFragJjType;
    private TextView mFragJjDes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_jj, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mFragJjDao = (TextView) view.findViewById(R.id.frag_jj_dao);
        mFragJjType = (TextView) view.findViewById(R.id.frag_jj_type);
        mFragJjDes = (TextView) view.findViewById(R.id.frag_jj_des);
    }
}
