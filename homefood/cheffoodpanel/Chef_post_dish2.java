package com.android.homefood.cheffoodpanel;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.android.homefood.Chef;
import com.android.homefood.Chef_bottom_navigation;
import com.android.homefood.Chefregistration;
import com.android.homefood.Customerlogin;
import com.android.homefood.MainActivity;
import com.android.homefood.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.UUID;

public class Chef_post_dish2 extends AppCompatActivity{
    Button post_dish;
    FirebaseStorage storage;
    StorageReference storageReference;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference,dataa;
    FirebaseAuth Fauth;
    StorageReference ref;
    String ChefId , RandomUID , Pin, House , Area;
    Spinner Dishes;
    TextInputLayout desc,qty,pri;
    String descrption,quantity,price,dishes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_post_dish2);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        Dishes = (Spinner)findViewById(R.id.dishes);
        desc = (TextInputLayout) findViewById(R.id.description);
        qty = (TextInputLayout) findViewById(R.id.Quantity);
        pri = (TextInputLayout) findViewById(R.id.price);
        post_dish = (Button) findViewById(R.id.post);
        Fauth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("FoodDetails");

        try {
            String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            dataa = FirebaseDatabase.getInstance().getReference("Chef").child(userid);
            dataa.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    Chef cheff = snapshot.getValue(Chef.class);
                    Pin = cheff.getPincode();
                    House = cheff.getHouse();
                    Area = cheff.getArea();
                    final ProgressDialog mDialog = new ProgressDialog(Chef_post_dish2.this);
                    post_dish.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dishes = Dishes.getSelectedItem().toString().trim();
                            descrption = desc.getEditText().getText().toString().trim();
                            quantity = qty.getEditText().getText().toString().trim();
                            price = pri.getEditText().getText().toString().trim();
                            if(isValid()){
                                mDialog.setCancelable(false);
                                mDialog.setCanceledOnTouchOutside(false);
                                mDialog.setMessage("Uploading please wait......");
                                mDialog.show();
                            }
                            RandomUID = UUID.randomUUID().toString();
                            ref = storageReference.child(RandomUID);
                            ChefId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            Food_details2 info = new Food_details2(dishes,quantity,price,descrption,RandomUID,ChefId);
                            firebaseDatabase.getInstance().getReference("FoodDetails").child(Pin).child(Area).child(House).child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID)
                                    .setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    mDialog.dismiss();
                                    AlertDialog.Builder food = new AlertDialog.Builder(Chef_post_dish2.this);
                                    food.setMessage("Your Dish has been uploaded!!");
                                    food.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            startActivity(new Intent(Chef_post_dish2.this, Chef_bottom_navigation.class));
                                        }
                                    });
                                }
                            });
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                                NotificationChannel channel = new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
                                NotificationManager manager = getSystemService(NotificationManager.class);
                                manager.createNotificationChannel(channel);
                            }

                            String message = "Dish posted Successfully";
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            PendingIntent pendingIntent = PendingIntent.getActivity(Chef_post_dish2.this, 0, intent, 0);

                            NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext()).setSmallIcon(R.drawable.ic_baseline_message_24)
                                    .setContentInfo("New Notification")
                                    .setContentText(message)
                                    .setChannelId("My Notification")
                                    .setContentIntent(pendingIntent)
                                    .setAutoCancel(true);

                            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
                            managerCompat.notify(1,builder.build());

                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }catch (Exception e){
            Log.e("Error: ",e.getMessage());
        }

    }
    private boolean isValid() {

        desc.setErrorEnabled(false);
        desc.setError("");
        qty.setErrorEnabled(false);
        qty.setError("");
        pri.setErrorEnabled(false);
        pri.setError("");

        boolean isValidDescription = false,isValidPrice=false,isValidQuantity=false,isValid=false;
        if(TextUtils.isEmpty(descrption)){
            desc.setErrorEnabled(true);
            desc.setError("Description is Required");
        }else{
            desc.setError(null);
            isValidDescription=true;
        }
        if(TextUtils.isEmpty(quantity)){
            qty.setErrorEnabled(true);
            qty.setError("Enter number of Plates or Items");
        }else{
            isValidQuantity=true;
        }
        if(TextUtils.isEmpty(price)){
            pri.setErrorEnabled(true);
            pri.setError("Please Mention Price");
        }else{
            isValidPrice=true;
        }
        isValid = (isValidDescription && isValidQuantity && isValidPrice)?true:false;
        return isValid;
    }
}
