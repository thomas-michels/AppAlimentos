package com.thomas.alimentos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thomas.alimentos.OnListClick;
import com.thomas.alimentos.R;
import com.thomas.alimentos.entity.FoodEntity;
import com.thomas.alimentos.viewHolder.FoodViewHolder;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private List<FoodEntity> mList;
    private OnListClick mListClick;

    public FoodAdapter(List<FoodEntity> mList, OnListClick listener) {
        this.mList = mList;
        this.mListClick = listener;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodEntity foodEntity = this.mList.get(position);
        holder.bind(foodEntity, this.mListClick);
    }

    @Override
    public int getItemCount() {
        return this.mList.size();
    }
}