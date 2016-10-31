package com.kosalgeek.androidmysql1.fonari;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kosalgeek.androidmysql1.MyApater;
import com.kosalgeek.androidmysql1.ProductRetrofit;
import com.kosalgeek.androidmysql1.R;
import com.kosalgeek.androidmysql1.petli.Info3;
import com.kosalgeek.androidmysql1.petli.WEB3;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static com.kosalgeek.androidmysql1.R.layout.frag3;

//import com.kosalgeek.androidmysql1.kovriki.Frag2;

/**
 * Created by Admin on 02.03.2016.
 */
public class Frag40 extends Fragment {
    ImageView img1;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                                @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(frag3,container,false);
        img1 = (ImageView) view.findViewById(R.id.imageView2);//zash
        img1.setVisibility(View.VISIBLE);
        final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressBar.setVisibility(ProgressBar.VISIBLE);

        final RecyclerView lvProduct = (RecyclerView) view.findViewById(R.id.lvProduct);
        lvProduct.setLayoutManager(new LinearLayoutManager(getActivity()));
        WEB40 web40=new WEB40();

        MyApater myApater=new MyApater(new ArrayList<ProductRetrofit>());

        lvProduct.setAdapter(myApater);
        web40.getAll(new Callback<ArrayList<ProductRetrofit>>() {
            @Override
            public void success(ArrayList<ProductRetrofit> productRetrofits, Response response) {

                MyApater myApater = new MyApater(productRetrofits);
                myApater.setOnItemClickListener(new MyApater.OnItemClickListener() {
                    @Override
                    public void onItemClick(Object item, int position) {
                        ProductRetrofit productRetrofit = (ProductRetrofit) item;
                        Intent intent = new Intent(getActivity(), Info40.class);
                        intent.putExtra("pid", productRetrofit.pid);
                        getActivity().startActivity(intent);
                    }
                });
                lvProduct.swapAdapter(myApater, false);
                img1.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(ProgressBar.INVISIBLE);
            }

            @Override
            public void failure(RetrofitError error) {
                img1.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(ProgressBar.INVISIBLE);
                Toast.makeText(getContext(), "Отсутствует подключениие к сети интернет", Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }
}
