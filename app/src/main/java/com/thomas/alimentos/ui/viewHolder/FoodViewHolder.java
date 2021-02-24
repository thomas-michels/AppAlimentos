package com.thomas.alimentos.ui.viewHolder;

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

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mTextName = itemView.findViewById(R.id.text_name);
        this.mTextCalories = itemView.findViewById(R.id.text_calories);
    }

    public void bind (FoodEntity food, OnListClick listener) {
        this.mTextName.setText(food.getName());
        this.mTextCalories.setText(String.valueOf(food.getCalories()));

        this.mTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(food.getId());
            }
        });
    }
}
