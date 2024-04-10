package com.example.ommafood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    public EditText txtLogin, txtPassword;
    public Button btnConnect, btnSignIn;
    private String login, password;
    public DBClass DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLogin = findViewById(R.id.txtLogin1);
        txtPassword = findViewById(R.id.txtPassword1);
        btnConnect = findViewById(R.id.btnConnect1);
        btnSignIn = findViewById(R.id.btnSignIn);

        DB = new DBClass(this);

        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = txtLogin.getText().toString().trim();
                password = txtPassword.getText().toString().trim();

                if(login.isEmpty() || password.isEmpty()){
                    String message = getString(R.string.error_field);
                    Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                }else{

                   boolean checkUserPassword = DB.checkUserPassword(login,password);
                    if(checkUserPassword==true){
                        if(login.equals("admin") && password.equals("admin")){
                            Toast.makeText(LoginActivity.this, "Bienvenue admin", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(LoginActivity.this, "Connexion reussi", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }
                    }else{
                        String message = getString(R.string.error_connection);
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, InscriptionActivity.class);
                startActivity(intent);
            }
        });
    }
}