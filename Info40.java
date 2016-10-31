package com.sanayq.androidmysql1.fonari;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sanayq.androidmysql1.ProductRetrofitFULL;
import com.sanayq.androidmysql1.R;
import com.sanayq.androidmysql1.petli.WEB3;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class Info40 extends AppCompatActivity {

    TextView name;
    TextView ops;
    TextView price;
    TextView nal;
    TextView pr;
    TextView sku;
    ImageView imageView1;
    ImageView imageView3;
    ImageView img1;
     ImageView img2;
    ImageView img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_info);


        name=(TextView)findViewById(R.id.name);
        ops=(TextView)findViewById(R.id.ops);
        price=(TextView)findViewById(R.id.price);
        nal=(TextView)findViewById(R.id.nal);
        pr=(TextView)findViewById(R.id.pr);
        sku=(TextView)findViewById(R.id.sku);
        imageView1=(ImageView)findViewById(R.id.imageView1);
        imageView3=(ImageView)findViewById(R.id.imageView3);
        setTitle("Подробности");

        String pid=Integer.toString(getIntent().getIntExtra("pid", 1));
        Log.e("pid", pid);

        WEB40 web40=new WEB40();
        web40.getById(pid, new Callback<List<ProductRetrofitFULL>>() {
            @Override
            public void success(List<ProductRetrofitFULL> o, Response response) {
                if(o!=null) {
                    try {
                        name.setText(o.get(0).name);
                        price.setText(o.get(0).price);
                        nal.setText(o.get(0).nal);
                        pr.setText(o.get(0).pr);
                        sku.setText(o.get(0).sku);
                        ops.setText(o.get(0).ops);
                        Glide.with(imageView1.getContext())
                                .load(o.get(0).image_url)
                                .into(imageView1);
                        Glide.with(imageView1.getContext())
                                .load(o.get(0).image_url)
                                .into(imageView3);
                        img3 = (ImageView)findViewById(R.id.imageView5);
                        img3.setVisibility(View.GONE);

                        img2 = (ImageView)findViewById(R.id.imageView1);//ordex
                        img1 = (ImageView)findViewById(R.id.imageView3);//zash

                        img2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                img2.setVisibility(View.GONE);
                                img1.setVisibility(View.VISIBLE);
                            }
                        });

                        img1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                img1.setVisibility(View.GONE);
                                img2.setVisibility(View.VISIBLE);

                            }
                        });
                        return;
                    } catch (Exception e) {

                    }
                }
               // Toast.makeText(getApplicationContext(),"Отсутствует подробная информация",Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });






    }
    public void call(View v)
    {
        EditText number=(EditText)findViewById(R.id.number);
        String toDial="tel:"+number.getText().toString();
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toDial)));
    }
}
