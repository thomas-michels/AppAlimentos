package com.thomas.alimentos.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thomas.alimentos.entity.FoodEntity;
import com.thomas.alimentos.viewHolder.FoodViewHolder;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private List<FoodEntity> mList;
    public FoodAdapter(List<FoodEntity> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.mList.size();
    }
}