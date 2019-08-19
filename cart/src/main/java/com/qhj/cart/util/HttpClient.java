package com.qhj.cart.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class HttpClient {
    private static final OkHttpClient CLIENT = new OkHttpClient();

    public static JSONObject get(String url) throws Exception {
        Request request = new Request.Builder().url(url).build();
        Response response = CLIENT.newCall(request).execute();
        return JSON.parseObject(response.body().string());
    }


}
