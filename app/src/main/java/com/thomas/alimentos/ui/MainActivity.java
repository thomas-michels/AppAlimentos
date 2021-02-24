package com.thomas.alimentos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.thomas.alimentos.services.listener.OnListClick;
import com.thomas.alimentos.ui.adapter.FoodAdapter;
import com.thomas.alimentos.services.business.FoodBusiness;
import com.thomas.alimentos.services.constants.FoodConstants;
import com.thomas.alimentos.entity.FoodEntity;
import com.thomas.alimentos.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private FoodBusiness mFoodBusiness = new FoodBusiness();
    private OnListClick mListener;
    private int mFilter =  FoodConstants.FILTER.NO_FILTER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mListener = new OnListClick() {
            @Override
            public void onClick(int id) {

                // Criando bundle para armazenar o id do item clicado
                Bundle bundle = new Bundle();
                bundle.putInt(FoodConstants.FOOD_ID, id);

                // Navegação
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        };

        // Obter a recycler view
        this.mViewHolder.mRecyclerFood = findViewById(R.id.recycler_food);

        // Criar layout
        this.mViewHolder.mRecyclerFood.setLayoutManager(new LinearLayoutManager(this));

        this.listFood();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Chamar menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Metodo de clicks do menu

        item.setChecked(true);

        // Filtro
        switch (item.getItemId()) {
            case R.id.filter_low: {
                this.mFilter = FoodConstants.FILTER.CAL_LOW;
                break;
            }
            case R.id.filter_medium: {
                this.mFilter = FoodConstants.FILTER.CAL_MEDIUM;
                break;
            }
            default: {
                this.mFilter = FoodConstants.FILTER.CAL_HIGH;
                break;
            }
        }
        this.listFood();
        return super.onOptionsItemSelected(item);
    }

    private void listFood(){
        List<FoodEntity> foodEntityList = this.mFoodBusiness.getList(this.mFilter);
        this.mViewHolder.mRecyclerFood.setAdapter(new FoodAdapter(foodEntityList, this.mListener));
    }

    private static class ViewHolder {
        RecyclerView mRecyclerFood;
    }
}