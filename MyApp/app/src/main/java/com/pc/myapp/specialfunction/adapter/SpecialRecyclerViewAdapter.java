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
import com.pc.myapp.specialfunction.bean.SpecialBean;

import java.util.List;

/**
 * Created by TR on 2017/12/14.
 */

public class SpecialRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<SpecialBean.RetBean.ListBean> list;
    private Context context;

    private OnItemClickListener mOnItemClickListener = null;
    public static interface OnItemClickListener {
        void onItemClick(SpecialBean.RetBean.ListBean listBean, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    public SpecialRecyclerViewAdapter(List<SpecialBean.RetBean.ListBean> list, Context context) {
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
        final SpecialBean.RetBean.ListBean listBean = list.get(position);
        myViewHolder.tv_title.setText(listBean.getChildList().get(0).getTitle());
        Glide.with(context).load(listBean.getChildList().get(0).getPic()).into( myViewHolder.img_video);
        myViewHolder.spitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(listBean,position);
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
