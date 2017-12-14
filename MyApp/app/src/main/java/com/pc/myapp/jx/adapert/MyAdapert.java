package com.pc.myapp.jx.adapert;

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
import com.pc.myapp.jx.bean.JxBean;

import java.util.List;

/**
 * Created by Helloworld on 2017/12/14.
 */

public class MyAdapert extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<JxBean.RetBean.ListBean.ChildListBean> list;
    private OnItemListener onItemListener;

    public interface OnItemListener {
        public void onItemClick(JxBean.RetBean.ListBean.ChildListBean childListBean);
    }

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }


    public MyAdapert(Context context, List<JxBean.RetBean.ListBean.ChildListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.jx_recyclerview, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.jx_rlv_tv.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getPic()).into(myViewHolder.jx_rlv_iv);
        myViewHolder.jx_rlv_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemListener.onItemClick(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView jx_rlv_iv;
        private final TextView jx_rlv_tv;
        private final LinearLayout jx_rlv_ll;

        public MyViewHolder(View itemView) {
            super(itemView);
            jx_rlv_iv = itemView.findViewById(R.id.jx_rlv_iv);
            jx_rlv_tv = itemView.findViewById(R.id.jx_rlv_tv);
            jx_rlv_ll = itemView.findViewById(R.id.jx_rlv_ll);
        }
    }

}
