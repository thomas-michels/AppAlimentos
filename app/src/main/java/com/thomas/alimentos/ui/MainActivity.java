package com.thomas.alimentos.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.thomas.alimentos.adapter.FoodAdapter;
import com.thomas.alimentos.business.FoodBusiness;
import com.thomas.alimentos.entity.FoodEntity;
import com.thomas.alimentos.R;
import com.thomas.alimentos.repository.FoodRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<FoodEntity> foodEntityList = new FoodBusiness().getList();

        // Obter a recycler view
        this.mViewHolder.mRecyclerFood = findViewById(R.id.recycler_food);

        // Adapter
        FoodAdapter adapter = new FoodAdapter(foodEntityList);
        this.mViewHolder.mRecyclerFood.setAdapter(adapter);

        // Criar layout
        this.mViewHolder.mRecyclerFood.setLayoutManager(new LinearLayoutManager(this));
    }

    private static class ViewHolder {
        RecyclerView mRecyclerFood;
    }
}