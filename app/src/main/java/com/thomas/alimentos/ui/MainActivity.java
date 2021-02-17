package com.thomas.alimentos.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.thomas.alimentos.entity.FoodEntity;
import com.thomas.alimentos.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FoodEntity f = new FoodEntity();
        f.getCalories();

        List<FoodEntity> foodEntityList = new ArrayList<>();

        this.mViewHolder.mRecyclerFood = findViewById(R.id.recycler_food);
    }

    private static class ViewHolder {
        RecyclerView mRecyclerFood;
    }
}