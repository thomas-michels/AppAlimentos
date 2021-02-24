package com.thomas.alimentos.ui.viewHolder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thomas.alimentos.services.listener.OnListClick;
import com.thomas.alimentos.R;
import com.thomas.alimentos.entity.FoodEntity;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextName;
    private TextView mTextCalories;
    private TextView mTextQuantity;
    private TextView mTextUnit;

    private Context mContext;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mContext = itemView.getContext();

        this.mTextName = itemView.findViewById(R.id.text_name);
        this.mTextCalories = itemView.findViewById(R.id.text_calories);
        this.mTextQuantity = itemView.findViewById(R.id.text_quantity);
        this.mTextUnit = itemView.findViewById(R.id.text_unit);
    }

    public void bind (FoodEntity food, OnListClick listener) {

        String strCalories = String.format("%s %s", food.getCalories(), this.mContext.getString(R.string.calorias));

        this.mTextName.setText(food.getName());
        this.mTextCalories.setText(strCalories);
        this.mTextQuantity.setText(String.valueOf(food.getQuantity()));
        this.mTextUnit.setText(food.getUnit());

        this.mTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(food.getId());
            }
        });
    }
}
