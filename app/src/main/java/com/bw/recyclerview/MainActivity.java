package com.bw.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bw.recyclerview.adapter.MyAdapter;
import com.bw.recyclerview.bean.Data;
import com.bw.recyclerview.utils.GetHttp;
import com.bw.recyclerview.utils.UrlUtils;
import com.google.gson.Gson;

public class MainActivity extends Activity {
private RecyclerView recyclerview;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(mLayoutManager);
        GetHttp();
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
                  runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          recyclerview.setAdapter(new MyAdapter(MainActivity.this,date));
                      }
                  });
              }
            }
        }.start();
    }
}
