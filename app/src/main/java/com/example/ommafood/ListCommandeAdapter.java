package com.example.ommafood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListCommandeAdapter extends ArrayAdapter<Commande> {


    public ListCommandeAdapter(Context context, ArrayList<Commande> commandes) {
        super(context, R.layout.list_commande_item, commandes);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Commande commands = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_commande_item, parent, false);
        }

        TextView plat = convertView.findViewById(R.id.commandeName);
        TextView adrr = convertView.findViewById(R.id.adresseCommande);
        TextView tel = convertView.findViewById(R.id.numeroTelephone);

        plat.setText(commands.repas);
        adrr.setText(commands.addresse);
        tel.setText(commands.telephone);



        return convertView;
    }
}
