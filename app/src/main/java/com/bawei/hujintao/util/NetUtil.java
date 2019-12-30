package com.bawei.hujintao.util;


import android.os.Handler;

import androidx.core.app.ServiceCompat;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 功能:  工具类
 * 作者:  胡锦涛
 * 时间:  2019/12/30 0030 上午 8:46
 */
public class NetUtil {
    private static NetUtil netUtil;
    private final Handler handler;
    private final OkHttpClient okHttpClient;

    private NetUtil(){
        handler = new Handler();
        okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    public static NetUtil getInstance() {
        if (netUtil==null){
            synchronized (NetUtil.class){
                if (netUtil==null){
                    netUtil=new NetUtil();
                }
            }
        }
        return netUtil;
    }
    //Get请求数据
    public void getJsonGet(String httpUrl, final MyCallback myCallback){
        Request build = new Request.Builder()
                .get()
                .url(httpUrl)
                .build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        myCallback.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response!=null&&response.isSuccessful()){
                    final String string = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myCallback.onGetJson(string);
                        }
                    });
                }else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myCallback.onError(new Exception("失败"));
                        }
                    });
                }
            }
        });
    }
    public interface MyCallback{
        void onGetJson(String json);
        void onError(Throwable throwable);
    }
}
