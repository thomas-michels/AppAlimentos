package com.thomas.alimentos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.thomas.alimentos.R;
import com.thomas.alimentos.services.business.FoodBusiness;
import com.thomas.alimentos.services.constants.FoodConstants;
import com.thomas.alimentos.entity.FoodEntity;

public class DetailsActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private int mId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Elementos de Interface
        this.mViewHolder.mTextName = findViewById(R.id.text_name);
        this.mViewHolder.mTextCalories = findViewById(R.id.text_calories);
        this.mViewHolder.mTextQuantity = findViewById(R.id.text_quantity);
        this.mViewHolder.mTextUnit = findViewById(R.id.text_unit);
        this.mViewHolder.mTextDescription = findViewById(R.id.text_description);

        this.getData();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // Pegando evento de click no botão de voltar
        if (item.getItemId() == android.R.id.home) {

            // Fecha a activity atual
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            this.mId = bundle.getInt(FoodConstants.FOOD_ID);

            // Carrega dados
            FoodEntity foodEntity = new FoodBusiness().get(this.mId);

            String strCalories = String.format("%s %s", foodEntity.getCalories(), this.getString(R.string.calorias));

            // Seta variaveis para aparecer na tela
            
            this.mViewHolder.mTextName.setText(foodEntity.getName());
            this.mViewHolder.mTextCalories.setText(strCalories);
            this.mViewHolder.mTextQuantity.setText(String.valueOf(foodEntity.getQuantity()));
            this.mViewHolder.mTextUnit.setText(foodEntity.getUnit());

            if (!foodEntity.getDescription().equals("")) {
                this.mViewHolder.mTextDescription.setText(foodEntity.getDescription());
            }
        }
    }

    private static class ViewHolder {
        TextView mTextName;
        TextView mTextCalories;
        TextView mTextQuantity;
        TextView mTextUnit;
        TextView mTextDescription;
    }
}