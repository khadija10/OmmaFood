package com.example.ommafood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InscriptionActivity extends AppCompatActivity {
    private EditText txtLogin, txtPassword, txtConfPassword;
    private Button btnSignUp;
    private String login, password, confPassword;
    public DBClass DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        txtLogin = findViewById(R.id.txtLogin);
        txtPassword = findViewById(R.id.txtPassword);
        txtConfPassword = findViewById(R.id.txtConfPassword);
        btnSignUp = findViewById(R.id.btnSigUp);
        DB = new DBClass(this);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login = txtLogin.getText().toString().trim();
                password = txtPassword.getText().toString().trim();
                confPassword = txtConfPassword.getText().toString().trim();

                if(login.isEmpty() || password.isEmpty() || confPassword.isEmpty()){
                    String message = getString(R.string.error_field);
                    Toast.makeText(InscriptionActivity.this, message, Toast.LENGTH_SHORT).show();

                }else{
                    if(password.equals(confPassword)){
                        boolean checkLogin = DB.checkUserLogin(login);
                        if(checkLogin==false){
                            boolean insert = DB.addUser(login,password);
                            if(insert==true){
                                String message = getString(R.string.success_inscription);
                                Toast.makeText(InscriptionActivity.this, message, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }else{
                                String message = getString(R.string.error_inscription);
                                Toast.makeText(InscriptionActivity.this, message, Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(InscriptionActivity.this, "Cet utilisateur est déjà inscrit", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(InscriptionActivity.this, "les mots de passe ne correspondent pas!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}