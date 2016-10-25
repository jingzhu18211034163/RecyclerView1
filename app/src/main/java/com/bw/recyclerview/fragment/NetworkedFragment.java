package com.bw.recyclerview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bw.recyclerview.R;
import com.bw.recyclerview.adapter.ListViewAdapter;
import com.bw.recyclerview.bean.Data;
import com.bw.recyclerview.utils.GetHttp;
import com.bw.recyclerview.utils.UrlUtils;
import com.google.gson.Gson;

/**
 * Created by 荆著 on 2016/10/24.
 */
public class NetworkedFragment extends Fragment {
    ListView lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.fragment_networked,null);
        lv=(ListView)view.findViewById(R.id.lv);
        GetHttp();
        return view;
    }
    public void GetHttp(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                String str= GetHttp.GetStringURL(UrlUtils.path);
                if(str!=null){
                    Gson gson=new Gson();
                    final Data date=gson.fromJson(str,Data.class);
                    Log.d("log",date.toString());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ListViewAdapter listViewAdapter=new ListViewAdapter(getActivity(),date);

                            lv.setAdapter(listViewAdapter);
                        }
                    });
                }
            }
        }.start();
    }
}
