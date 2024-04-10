package com.example.ommafood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ommafood.databinding.ActivityMealBinding;

public class MealActivity extends AppCompatActivity {
    private ActivityMealBinding binding;
    public Button btnCommande;
    public String noms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMealBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        btnCommande = findViewById(R.id.btnCommande);





        Intent intent = this.getIntent();

        if(intent != null){
            noms = intent.getStringExtra("noms");
            String dets = intent.getStringExtra("deta");
            String couts = intent.getStringExtra("cout");
            int imageId = intent.getIntExtra("imageId", R.drawable.yassa_poulet);

            binding.mealNom.setText(noms);
            binding.mealDetails.setText(dets);
            binding.prixView.setText(couts);
            binding.imageProfile.setImageResource(imageId);


        }

    }

}