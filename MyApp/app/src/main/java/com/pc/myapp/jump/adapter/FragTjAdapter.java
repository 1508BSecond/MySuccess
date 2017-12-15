package com.pc.myapp.jump.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pc.myapp.R;
import com.pc.myapp.jump.bean.DetailBean;

import java.util.List;

/**
 * Created by pc on 2017/12/15.
 */

public class FragTjAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<DetailBean.RetBean.ListBean.ChildListBean> childList;

    public FragTjAdapter(Context context, List<DetailBean.RetBean.ListBean.ChildListBean> childList) {
        this.context = context;
        this.childList = childList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.tj_rlv_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        Glide.with(context).load(childList.get(position).getPic()).into(myViewHolder.iv);
        myViewHolder.tv.setText(childList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return childList.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv;
        private final TextView tv;
        private final LinearLayout ll;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.tj_rlv_iv);
            tv = itemView.findViewById(R.id.tj_rlv_tv);
            ll = itemView.findViewById(R.id.tj_rlv_ll);
        }
    }
}
