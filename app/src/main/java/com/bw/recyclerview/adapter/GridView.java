package com.bw.recyclerview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.recyclerview.R;
import com.bw.recyclerview.bean.Data;

/**
 * Created by 荆著 on 2016/10/24.
 */
public class GridView extends BaseAdapter {
    private Context context;
    private Data date;

    public GridView(Context context, Data date) {
        this.context = context;
        this.date = date;
    }

    @Override
    public int getCount() {
        return date.data.forum_list.get(0).group.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder=new ViewHolder();
            view=View.inflate(context, R.layout.gv_item,null);
            holder.iv=(ImageView)view.findViewById(R.id.gv_iv_item);
            holder.tv_name=(TextView)view.findViewById(R.id.gv_tv_name);
            view.setTag(holder);
        }else{
            holder=(ViewHolder)view.getTag();
        }

            holder.tv_name.setText(date.data.forum_list.get(0).group.get(i).name);
            Glide.with(context).load(date.data.forum_list.get(0).group.get(i).photo).into(holder.iv);

        return view;
    }
    class ViewHolder{
        TextView tv_name;
        ImageView iv;
    }
}
