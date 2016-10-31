package com.sanayq.androidmysql1.fonari;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sanayq.androidmysql1.ProductRetrofit;
import com.sanayq.androidmysql1.ProductRetrofitFULL;
import com.sanayq.androidmysql1.petli.LINK3;
import com.squareup.okhttp.OkHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

/**
 * Created by Admin on 02.03.2016.
 */
public class WEB40 {
    public static String BASE_URL = "http://k95260i7.bget.ru/";

    Gson gson = new GsonBuilder()
            .create();

    private RestAdapter mRest = new RestAdapter.Builder()
            .setEndpoint(BASE_URL)
            .setConverter(new GsonConverter(gson))
            .setClient(new OkClient(new OkHttpClient()))
            .build();

    private LINK40 link40 = mRest.create(LINK40.class);


    public static String responseToString(Response response) {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(response.getBody().in()));
            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void getAll(Callback<ArrayList<ProductRetrofit>> c){
        link40.getAll(c);
    }

    public void getById(String pid, Callback<List<ProductRetrofitFULL>> callback) {
        link40.getById(pid,callback);
    }
}
