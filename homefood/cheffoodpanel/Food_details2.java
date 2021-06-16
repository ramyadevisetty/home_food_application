package com.android.homefood.cheffoodpanel;

import android.os.Bundle;

public class Food_details2 {

    public String Dishes,Quantity,Price,Description,RandomUID,Chefid;
    // Alt+insert
    public Food_details2(){
    }

    public Food_details2(String dishes, String quantity, String price, String description, String randomUID, String chefid) {
        Dishes = dishes;
        Quantity = quantity;
        Price = price;
        Description = description;
        RandomUID = randomUID;
        Chefid = chefid;
    }
}