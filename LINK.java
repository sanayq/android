package com.sanayq.androidmysql1;

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
public interface LINK {
    @GET("/category.php")
    void getMenu(
            Callback<List<CategoryRetrofit>> c);


}
