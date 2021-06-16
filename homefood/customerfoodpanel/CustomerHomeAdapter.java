package com.android.homefood.customerfoodpanel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.android.homefood.R;
import com.android.homefood.UpdateDishModel;

public class CustomerHomeAdapter extends RecyclerView.Adapter<CustomerHomeAdapter.ViewHolder> {

    private Context mcont;
    private List<UpdateDishModel> updateDishModelList;

    public CustomerHomeAdapter(Context context , List<UpdateDishModel>updateDishModelList){
        this.updateDishModelList = updateDishModelList;
        this.mcont = context;
    }

    @NonNull
    @Override
    public CustomerHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcont).inflate(R.layout.customer_menudish,parent,false);
        return new CustomerHomeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerHomeAdapter.ViewHolder holder, int position) {

        final UpdateDishModel updateDishModel = updateDishModelList.get(position);
        holder.dishes.setText("Chapati");
        updateDishModel.getRandomUID();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcont,Customer_food_menu.class);
                intent.putExtra("updatedeletedish",updateDishModel.getRandomUID());
                mcont.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return updateDishModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView dishes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dishes = itemView.findViewById(R.id.dish_name);
        }
    }
}
