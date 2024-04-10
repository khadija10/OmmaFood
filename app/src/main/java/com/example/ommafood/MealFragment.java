package com.example.ommafood;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class MealFragment extends Fragment {
    private ListView listMeal;
    private String[] noms;
    private String meal;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meal, container, false);
        listMeal = view.findViewById(R.id.listView);


        int[] imageId = {R.drawable.yassa_poulet, R.drawable.fouti, R.drawable.thiebou_guinar, R.drawable.thiebou_yapp, R.drawable.attasi, R.drawable.madesu, R.drawable.dakhine};
        noms = new String[]{"Yassa poulet", "Foutti", "Thiebou poulet", "Thiebou viande", "Atassi", "Madesu", "Dakhine"};
        String[] desc = {"Plat senegalais", "Plat guinéen", "Plat senegalais", "Plat senegalais", "Plat beninois", "Plat congolais", "Plat sénégalais"};
        String[] cout = {"1500f", "1000f", "2000f", "2000f", "1500f", "2000f", "1000f"};
        ArrayList<Meal> plats = new ArrayList<>();
        for (int i = 0; i < imageId.length; i++){
            Meal meale = new Meal(imageId[i],noms[i], desc[i], cout[i]);
            plats.add(meale);
        }

        ListAdapter listAdapter = new ListAdapter(getActivity(), plats);
        listMeal.setAdapter(listAdapter);
        listMeal.setClickable(true);
        listMeal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String msg =desc[position] +"\n"+ cout[position];
                meal = noms[position];
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(meal);
                builder.setIcon(imageId[position]);
                builder.setMessage(msg);
                builder.setNegativeButton("Annuler", null);
                builder.setPositiveButton("Commander", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        CommandeFragment.plat = meal;
                        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_home, new CommandeFragment()).addToBackStack(null).commit();
                    }
                });

                builder.show();
            }
        });

        /*listMeal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), MealActivity.class);
                intent.putExtra("noms", noms[position]);
                intent.putExtra("deta", desc[position]);
                intent.putExtra("cout", cout[position]);
                intent.putExtra("imageId", imageId[position]);
                startActivity(intent);
            }
        });*/


        return view;
    }

}