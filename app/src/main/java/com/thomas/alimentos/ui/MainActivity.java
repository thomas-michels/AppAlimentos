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

import com.thomas.alimentos.listener.OnListClick;
import com.thomas.alimentos.adapter.FoodAdapter;
import com.thomas.alimentos.business.FoodBusiness;
import com.thomas.alimentos.constants.FoodConstants;
import com.thomas.alimentos.entity.FoodEntity;
import com.thomas.alimentos.R;

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

        OnListClick foodListener = new OnListClick() {
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

        // Adapter
        FoodAdapter adapter = new FoodAdapter(foodEntityList, foodListener);
        this.mViewHolder.mRecyclerFood.setAdapter(adapter);

        // Criar layout
        this.mViewHolder.mRecyclerFood.setLayoutManager(new LinearLayoutManager(this));
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

            }
            case R.id.filter_medium: {

            }
            default: {

            }
        }
        return super.onOptionsItemSelected(item);
    }

    private static class ViewHolder {
        RecyclerView mRecyclerFood;
    }
}