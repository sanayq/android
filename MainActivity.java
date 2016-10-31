package com.kosalgeek.androidmysql1;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


import com.kosalgeek.androidmysql1.aksesuary.Frag;
import com.kosalgeek.androidmysql1.fonari.Frag40;
import com.kosalgeek.androidmysql1.ledovoe_snaryazhenie.Frag1;
import com.kosalgeek.androidmysql1.petli.Frag3;
import com.kosalgeek.androidmysql1.promalp.Frag4;
import com.kosalgeek.androidmysql1.skalnoe.Frag5;
import com.kosalgeek.androidmysql1.strahovochnoe.FragKat;
import com.kosalgeek.androidmysql1.toplivnoe_oborydovanie.Frag30;
//import com.kosalgeek.androidmysql1.zzz.Frag30;

import java.util.ArrayList;
//import com.kosalgeek.androidmysql1.kovriki.Frag2;
//import com.kosalgeek.androidmysql1.ledovo_snezhnoe_snaryazhenie.Frag3;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout = null;
    private android.support.v7.app.ActionBarDrawerToggle drawerToggle = null;


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (drawerLayout != null)
            drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (drawerLayout != null)
            drawerToggle.onConfigurationChanged(newConfig);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sub);

      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout=(DrawerLayout)findViewById(R.id.view);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {

                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);

        drawerToggle.syncState();

        NavigationView navigationView=(NavigationView)findViewById(R.id.nvView);
        //navigationView.getMenu().add(1,26,100,"фонари");
        ArrayList<String> arrayPid = getIntent().getStringArrayListExtra("arrayPid");
        ArrayList<String> arrayName = getIntent().getStringArrayListExtra("arrayName");
        for(int i=0;i<arrayPid.size();++i){
            navigationView.getMenu().add(1,Integer.parseInt(arrayPid.get(i)),100,arrayName.get(i));
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
                if (item.getItemId() == 1) {
                    // getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new Frag2()).commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment, new Frag()).commit();
                } else if (item.getItemId() == 2) {
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment, new Frag1()).commit();
                } else if (item.getItemId() == 3) {
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment, new Frag3()).commit();
                } else if (item.getItemId() == 4) {
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment, new Frag4()).commit();
                } else if (item.getItemId() == 5) {
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment, new Frag5()).commit();
                } else if (item.getItemId() == 6) {
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment, new FragKat()).commit();
                }else if (item.getItemId() == 7) {
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment, new Frag30()).commit();
                }else if (item.getItemId() == 8) {
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment, new Frag40()).commit();
                }

                return false;
            }
        });
        //PostResponseAsyncTask task = new PostResponseAsyncTask(MainActivity.this, this);





    }
        //task.execute("http://k95260i7.bget.ru/product.php");





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case android.R.id.home:
                if(drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.closeDrawers();
                else
                    drawerLayout.openDrawer(GravityCompat.START);
                return true;

        }

        return super.onOptionsItemSelected(item);

    }


    public void call(View v)
    {
        EditText number=(EditText)findViewById(R.id.number);
        String toDial="tel:"+number.getText().toString();
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toDial)));
    }

}