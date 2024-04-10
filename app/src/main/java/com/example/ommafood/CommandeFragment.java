package com.example.ommafood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class CommandeFragment extends Fragment {

    public EditText txtAdresse, txtTelephone;
    public Button btnSaveCommande;
    private String adresse, telephone;
    public static String plat;
    public DBClass DB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_commande, container, false);
        txtAdresse = view.findViewById(R.id.txtAdresse);
        txtTelephone = view.findViewById(R.id.txtPhone);
        btnSaveCommande = view.findViewById(R.id.btnSaveCommande);
        DB = new DBClass(getActivity());


        btnSaveCommande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adresse = txtAdresse.getText().toString().trim();
                telephone = txtTelephone.getText().toString().trim();

                String wods = plat + "   " + adresse + "   "+ telephone;
                Toast.makeText(getActivity(), wods, Toast.LENGTH_SHORT).show();

                if(adresse.isEmpty() || telephone.isEmpty()){
                    String message = getString(R.string.error_field);
                    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                }else {
                    boolean addCommande = DB.addCommande(plat,adresse,telephone);
                    if(addCommande==true){
                        Toast.makeText(getActivity(), "Commande éffectuée", Toast.LENGTH_SHORT).show();
                        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_home, new MealFragment()).addToBackStack(null).commit();
                    }else{
                        Toast.makeText(getActivity(), "veillez verifier les infos saisies", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        return view;
    }
}