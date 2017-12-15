package com.pc.myapp.jump.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.pc.myapp.R;
import com.pc.myapp.jump.bean.PlInfoBean;

import java.util.List;

/**
 * Created by pc on 2017/12/15.
 */

public class FragPlAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<PlInfoBean.RetBean.ListBean> list;

    public FragPlAdapter(Context context, List<PlInfoBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.pl_rlv_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.sdv.setImageURI(Uri.parse(list.get(position).getUserPic()));
        myViewHolder.tv_phone.setText(list.get(position).getPhoneNumber());
        myViewHolder.tv_time.setText(list.get(position).getTime());
        myViewHolder.tv_msg.setText(list.get(position).getMsg());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView tv_phone;
        private final TextView tv_time;
        private final TextView tv_msg;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.pl_rlv_sdv);
            tv_phone = itemView.findViewById(R.id.pl_rlv_tv_phone);
            tv_time = itemView.findViewById(R.id.pl_rlv_tv_time);
            tv_msg = itemView.findViewById(R.id.pl_rlv_tv_msg);
        }
    }

}
