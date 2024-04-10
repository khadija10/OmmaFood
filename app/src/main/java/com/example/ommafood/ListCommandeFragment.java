package com.example.ommafood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ListCommandeFragment extends Fragment {
    private ListView listCommande;
    private String[] names, adresses, telephones;
    public DBClass DB;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_list_commande, container, false);
        listCommande = view.findViewById(R.id.listCommandeView);



        names = DB.getCommande().toArray(new String[1]);
        adresses = DB.getCommande().toArray(new String[2]);
        telephones = DB.getCommande().toArray(new String[3]);


        ArrayList<Commande> commandes = new ArrayList<>();
        for (int i = 0; i < names.length; i++){
            Commande command = new Commande(names[i], adresses[i], telephones[i]);
            commandes.add(command);
        }

        ListCommandeAdapter listAdapter = new ListCommandeAdapter(getActivity(), commandes);
        listCommande.setAdapter(listAdapter);


        return view;
    }
}