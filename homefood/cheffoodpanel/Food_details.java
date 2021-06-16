package com.android.homefood.cheffoodpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.homefood.R;

public class Food_details extends AppCompatActivity {

    public String Dishes,Quantity,Price,Description,ImageURL,RandomUID,Chefid;
    // Alt+insert

    public Food_details(String dishes, String quantity, String price, String description, String imageURL, String randomUID, String chefid) {
        Dishes = dishes;
        Quantity = quantity;
        Price = price;
        Description = description;
        ImageURL = imageURL;
        RandomUID = randomUID;
        Chefid = chefid;
    }
}