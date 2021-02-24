package com.thomas.alimentos.services.business;

import com.thomas.alimentos.services.constants.FoodConstants;
import com.thomas.alimentos.entity.FoodEntity;
import com.thomas.alimentos.services.repository.FoodRepository;

import java.util.ArrayList;
import java.util.List;

public class FoodBusiness {

    private FoodRepository mFoodRepository = new FoodRepository();

    public FoodEntity get(int id) {
        return this.mFoodRepository.get(id);
    }

    public List<FoodEntity> getList(int filter) {

        List<FoodEntity> list = this.mFoodRepository.getList();
        List<FoodEntity> filtered = new ArrayList<>();

        if (FoodConstants.FILTER.NO_FILTER == filter) {
            return list;
        }

        for (FoodEntity f: list) {
            if (FoodConstants.FILTER.CAL_LOW == filter) {
                if (f.getCalories() <= 99) {
                    filtered.add(f);
                }
            }
            else if (FoodConstants.FILTER.CAL_MEDIUM == filter) {
                if (f.getCalories() >= 100 && f.getCalories() <= 199) {
                    filtered.add(f);
                }
            }
            else if (FoodConstants.FILTER.CAL_HIGH == filter){
                if (f.getCalories() >= 200) {
                    filtered.add(f);
                }
            }
        }
        return filtered;
    }
}
