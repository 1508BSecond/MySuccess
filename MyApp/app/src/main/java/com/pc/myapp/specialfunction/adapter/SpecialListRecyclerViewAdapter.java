package com.pc.myapp.specialfunction.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pc.myapp.R;
import com.pc.myapp.specialfunction.bean.ListDtBean;

import java.util.List;

/**
 * Created by TR on 2017/12/14.
 */

public class SpecialListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ListDtBean.RetBean.ListBean> list;
    private Context context;

    private OnItemClickListener mOnItemClickListener = null;

    public static interface OnItemClickListener {
        void onItemClick(List<ListDtBean.RetBean.ListBean> list, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public SpecialListRecyclerViewAdapter(List<ListDtBean.RetBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.ztitem, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        final ListDtBean.RetBean.ListBean listBean = list.get(position);
        myViewHolder.tv_title.setText(listBean.getTitle());
        Glide.with(context).load(listBean.getPic()).into(myViewHolder.img_video);
        myViewHolder.spitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick((List<ListDtBean.RetBean.ListBean>) listBean,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        private final TextView tv_title;
        private final ImageView img_video;
        private final LinearLayout spitem;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            img_video = itemView.findViewById(R.id.img_video);
            spitem = itemView.findViewById(R.id.spitem);

        }
    }
}
