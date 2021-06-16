package com.android.homefood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choosecustomer extends AppCompatActivity {
    Button chef,customer;
    String type;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosecustomer);
        intent = getIntent();
        type = intent.getStringExtra("Home").toString().trim();

        chef = (Button)findViewById(R.id.chef);
        customer = (Button)findViewById(R.id.customer);
        chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("SignIn")) {
                    Intent Sign_in = new Intent(Choosecustomer.this, Cheflogin.class);
                    startActivity(Sign_in);
                    finish();
                }
                if(type.equals("SignUp")) {
                    Intent Sign_up = new Intent(Choosecustomer.this, Chefregistration.class);
                    startActivity(Sign_up);
                }
            }
        });
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("SignIn")) {
                    Intent Sign_in = new Intent(Choosecustomer.this, Customerlogin.class);
                    startActivity(Sign_in);
                    finish();
                }
                if(type.equals("SignUp")) {
                    Intent Sign_up = new Intent(Choosecustomer.this, Customerregistration.class);
                    startActivity(Sign_up);
                }
            }
        });
    }
}