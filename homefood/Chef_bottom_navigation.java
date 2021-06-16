package com.android.homefood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.android.homefood.cheffoodpanel.Chef_home;
import com.android.homefood.cheffoodpanel.Chef_profile;
import com.android.homefood.cheffoodpanel.Chef_profile_page;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Chef_bottom_navigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.chef_bottom_navigation);
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
            case R.id.chefHome:
                fragment= new Chef_home();
                break;
            case R.id.chefProfile:
                fragment=new Chef_profile();
                break;
            case R.id.chefProfilepage:
                fragment = new Chef_profile_page();
        }
        return loadcheffragment(fragment);
    }
}