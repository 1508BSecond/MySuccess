package com.pc.myapp.FX.adapter;

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
 * Created by wangziying on 2017/12/14.
 */

public class FXMyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<JxBean.RetBean.ListBean.ChildListBean> list;
    private Context context;

    //自定义的用来点击的接口
    private OnItemListener onItemListener;
    public interface OnItemListener{
         void OnCilck(JxBean.RetBean.ListBean.ChildListBean dataBean);
    }
    public void setOnItemListener(OnItemListener onItemListener){
        this.onItemListener = onItemListener;
    }

    public FXMyAdapter(List<JxBean.RetBean.ListBean.ChildListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.fx_item, null);
        return new Myhodelview(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        Myhodelview ho= (Myhodelview) holder;

        String title = list.get(position).getTitle();
        String pic = list.get(position).getPic();
        String description = list.get(position).getDescription();

        ho.title.setText(title);
        Glide.with(context).load(pic).into(ho.img);
        ho.tv.setText(description);

        ho.line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemListener.OnCilck(list.get(position));
            }
        });

        /*if(position==list.size()){
            Toast.makeText(context, "已经没有数据了,请点击换一批", Toast.LENGTH_SHORT).show();
        }*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Myhodelview extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        private TextView tv;
        private LinearLayout line;

        public Myhodelview(View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.tv);
            title = itemView.findViewById(R.id.title);
            img = itemView.findViewById(R.id.img);
            line=itemView.findViewById(R.id.line);
        }
    }
    
}
