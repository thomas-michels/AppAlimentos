package com.thomas.alimentos.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    public void bind (FoodEntity food) {
        this.mTextName.setText(food.getName());

        // String.valueOf converte o int em string
        this.mTextCalories.setText(String.valueOf(food.getCalories()));
    }
}
