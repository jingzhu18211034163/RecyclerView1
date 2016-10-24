package com.bw.recyclerview.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 荆著 on 2016/10/8.
 */
public class GetHttp {
    static String result = null ;
    public static String GetStringURL(String urlStr) {
        String result = null;
        URL url;
        HttpURLConnection conn = null;
        BufferedReader br = null;
        try {
            url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5 * 1000);
            conn.setReadTimeout(5000);
            if (conn.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                StringBuilder sb = new StringBuilder();
                String lineStr = null;
                while ((lineStr = br.readLine()) != null) {
                    sb.append(lineStr).append("\n");
                }
                result = sb.toString();
            } else {
                System.out.println("访问url: " + url + "/n服务器响应失败！");
            }
        } catch (MalformedURLException e) {
            System.out.println("" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                    br = null;
                }
                if (conn != null) {
                    conn.disconnect();
                    conn = null;
                }
            } catch (IOException e) {
                System.out.println("" + e.getMessage());
                e.printStackTrace();
            }
        }
        return result;
    }
}
