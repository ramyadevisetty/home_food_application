package com.android.homefood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    Button signinwithemail, signup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        signinwithemail=(Button)findViewById(R.id.customer);
        signup=(Button)findViewById(R.id.Register);

        signinwithemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signemail = new Intent(MainMenu.this, Choosecustomer.class);
                signemail.putExtra("Home","SignIn");
                startActivity(signemail);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Signup = new Intent(MainMenu.this,Choosecustomer.class);
                Signup.putExtra("Home","SignUp");
                startActivity(Signup);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }
}