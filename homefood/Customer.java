package com.android.homefood;

public class Customer {


    private String Area,ConfirmPassword,EmailID,FirstName,House,LastName,Password,Pincode;



    public Customer(String area,String confirmPassword, String emailID, String firstName,String house,String lastName, String password,String pincode) {
        this.Area = area;
        ConfirmPassword=confirmPassword;
        EmailID = emailID;
        FirstName=firstName;
        House = house;
        LastName=lastName;
        Password = password;
        Pincode = pincode;

    }
    public Customer(){}

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String emailID) {
        EmailID = emailID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getHouse() {
        return House;
    }

    public void setHouse(String house) {
        House = house;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String pincode) {
        Pincode = pincode;
    }
}
