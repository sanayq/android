package com.sanayq.androidmysql1;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        boolean have_internet=false;
        ConnectivityManager connec = (ConnectivityManager) getApplicationContext()
                .getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connec.getActiveNetworkInfo();
        have_internet=(networkInfo != null && networkInfo.isConnected());

        if(have_internet){
            WEB web=new WEB();
            web.getMenu(new Callback<List<CategoryRetrofit>>() {
                @Override
                public void success(List<CategoryRetrofit> categoryRetrofits, Response response) {
                    ArrayList<String> arrayPid=new ArrayList<String>();
                    ArrayList<String> arrayName=new ArrayList<String>();
                    for(CategoryRetrofit categoryRetrofit : categoryRetrofits){
                        arrayPid.add(categoryRetrofit.id);
                        arrayName.add(categoryRetrofit.categor);
                    }
                    Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                    intent.putStringArrayListExtra("arrayPid",arrayPid);
                    intent.putStringArrayListExtra("arrayName",arrayName);
                    startActivity(intent);
                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(SplashActivity.this,"Отсутствует соединение с Интернетом! Включите Интернет и повторно войдите в приложение.",Toast.LENGTH_LONG).show();
                    SplashActivity.this.finish();
                }
            });
        }
        else {
            Toast.makeText(this,"Отсутствует соединение с Интернетом! Включите Интернет и повторно войдите в приложение.",Toast.LENGTH_LONG).show();
            SplashActivity.this.finish();
        }
    }


}
