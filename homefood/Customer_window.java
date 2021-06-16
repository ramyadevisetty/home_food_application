package com.android.homefood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.android.homefood.cheffoodpanel.Chef_home;
import com.android.homefood.cheffoodpanel.Chef_profile;
import com.android.homefood.customerfoodpanel.Customer_home;
import com.android.homefood.customerfoodpanel.Customer_home_fragment;
import com.android.homefood.customerfoodpanel.Customer_profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Customer_window extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_window);
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }
    private boolean loadcheffragment(Fragment fragment) {

        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.Home:
                fragment= new Customer_home_fragment();
                break;
            case R.id.Profile:
                fragment=new Customer_profile();
                break;
        }
        return loadcheffragment(fragment);
    }
}