package com.kosalgeek.androidmysql1;


import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("pid")
    public int pid;

    @SerializedName("name")
    public String name;

    @SerializedName("qty")
    public String qty;

    @SerializedName("price")
    public String price;

    @SerializedName("image_url")
    public String image_url;

}
