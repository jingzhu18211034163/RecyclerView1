package com.bw.recyclerview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.bw.recyclerview.R;
import com.bw.recyclerview.bean.Data;
import com.bw.recyclerview.utils.GetHttp;
import com.bw.recyclerview.utils.UrlUtils;
import com.google.gson.Gson;

/**
 * Created by 荆著 on 2016/10/24.
 */
public class DepartmentsFragment extends Fragment {
    private GridView gv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_departments,null);
        gv=(GridView)view.findViewById(R.id.gv);
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
                            com.bw.recyclerview.adapter.GridView gridView=new com.bw.recyclerview.adapter.GridView(getActivity(),date);

                            gv.setAdapter(gridView);
                        }
                    });
                }
            }
        }.start();
    }
}
