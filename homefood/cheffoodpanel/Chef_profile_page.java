package com.android.homefood.cheffoodpanel;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.homefood.Chef;
import com.android.homefood.Customer;
import com.android.homefood.MainMenu;
import com.android.homefood.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Chef_profile_page extends Fragment {
    TextView firstname, lastname;
    TextView Email;
    Button Logoutt;
    LinearLayout LogOut;
    DatabaseReference databaseReference, data;
    FirebaseDatabase firebaseDatabase;
    TextView Pincode;
    TextView Area;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Profile");
        View v = inflater.inflate(R.layout.fragment_chef_profile_page, null);

        firstname = (TextView) v.findViewById(R.id.fnameee);
        lastname = (TextView) v.findViewById(R.id.lnameee);
        Email = (TextView) v.findViewById(R.id.eemailID);
        Pincode = (TextView) v.findViewById(R.id.pincodee);
        Logoutt = (Button) v.findViewById(R.id.loggout);
        Area = (TextView) v.findViewById(R.id.areaaa);
        String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("Chef").child(userid);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final Chef customer = dataSnapshot.getValue(Chef.class);

                firstname.setText("ramya");
                lastname.setText("devisetty");
                Email.setText("ramya26091999@gmail.com");
                Area.setText(customer.getArea());
                Pincode.setText(customer.getPincode());
                Logoutt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(getActivity(), MainMenu.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return v;
    }
}
