package com.thomas.alimentos.business;

import com.thomas.alimentos.entity.FoodEntity;
import com.thomas.alimentos.repository.FoodRepository;

import java.util.List;

public class FoodBusiness {

    public FoodEntity get(int id) {
        return new FoodRepository().get(id);
    }

    public List<FoodEntity> getList() {
        return new FoodRepository().getList();
    }
}
