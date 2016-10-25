package com.bw.recyclerview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bw.recyclerview.R;
import com.bw.recyclerview.bean.Data;

/**
 * Created by 荆著 on 2016/10/24.
 */
public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private Data date;
    public ListViewAdapter(Context context, Data date) {
        this.context = context;
        this.date = date;
    }
    @Override
    public int getCount() {
        return date.data.forum_list.get(1).group.size();
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
            view=View.inflate(context, R.layout.lv_item,null);

            holder.tv_name=(TextView)view.findViewById(R.id.lv_tv_name);
            view.setTag(holder);
        }else{
            holder=(ViewHolder)view.getTag();
        }

        holder.tv_name.setText(date.data.forum_list.get(1).group.get(i).name);

        return view;
    }
    class ViewHolder{
        TextView tv_name;

    }
}
