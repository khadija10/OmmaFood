package com.example.ommafood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Meal> {
    public  ListAdapter(Context context, ArrayList<Meal> meals){
        super(context, R.layout.list_item, meals);


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Meal meals = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView view = convertView.findViewById(R.id.photo);
        TextView plat = convertView.findViewById(R.id.mealName);
        TextView description = convertView.findViewById(R.id.detail);
        TextView money = convertView.findViewById(R.id.prix);

        view.setImageResource(meals.imageId);
        plat.setText(meals.meal);
        description.setText(meals.detail);
        money.setText(meals.prix);



        return convertView;
    }
}
