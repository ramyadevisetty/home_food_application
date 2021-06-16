package com.android.homefood;

import android.os.Bundle;

public class Chef {

    private String Area, ConfirmPassword, Emailid, Fname, House, Lname, Password, Pincode;


    public Chef(String area, String confirmPassword, String emailid, String fname, String house, String lname, String password, String pincode) {
        this.Area = area;
        ConfirmPassword = confirmPassword;
        Emailid = emailid;
        Fname = fname;
        House = house;
        Lname = lname;
        Password = password;
        Pincode = pincode;
    }
    public Chef() {
    }

    public String getArea() {
        return Area;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public String getEmailid() {
        return Emailid;
    }

    public String getFname() {
        return Fname;
    }

    public String getHouse() {
        return House;
    }

    public String getLname() {
        return Lname;
    }

    public String getPassword() {
        return Password;
    }

    public String getPincode() {
        return Pincode;
    }
}