package com.kosalgeek.androidmysql1.fonari;

import com.kosalgeek.androidmysql1.ProductRetrofit;
import com.kosalgeek.androidmysql1.ProductRetrofitFULL;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Admin on 02.03.2016.
 */
public interface LINK40 {
    @FormUrlEncoded
    @POST("/characteristics_fonari.php")
    void getById(
            @Field("pid") String pid,
            Callback<List<ProductRetrofitFULL>> c);


    @GET("/product_fonari.php")
    void getAll(
            Callback<ArrayList<ProductRetrofit>> c);
}
