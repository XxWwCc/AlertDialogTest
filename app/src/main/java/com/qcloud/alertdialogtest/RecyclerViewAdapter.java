package com.qcloud.alertdialogtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> implements View.OnClickListener{

    private Context mContext;
    private List<String> data;
    private OnItemClickListener onItemClickListener;

    public RecyclerViewAdapter(Context context, List<String> data,OnItemClickListener onItemClickListener){
        this.mContext = context;
        this.data=data;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override/*负责为item创建视图*/
    public RecyclerViewAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_of_citys,parent,false);
        myViewHolder holder = new myViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override/*负责将数据绑定到item的视图上*/
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.myViewHolder viewHolder, int position) {
        viewHolder.textView.setText(data.get(position));
        viewHolder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener!=null) {
            onItemClickListener.onItemClick((Integer) view.getTag());
        }
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_city);
        }
    }
}