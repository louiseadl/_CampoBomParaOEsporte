package com.telahome.campobomparaoesporte.ui.login;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.telahome.campobomparaoesporte.MainActivity;
import com.telahome.campobomparaoesporte.MapsActivity;
import com.telahome.campobomparaoesporte.R;
import com.telahome.campobomparaoesporte.RegisterActivity;



public class LoginActivity extends AppCompatActivity {

    //declarar componentes

    private Button btVoltar;
    private Button btLogin;
    private Button btResgistrar;
    private EditText etEmail;
    private EditText etSenha;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        start();

        //voltar pra home

        this.btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itHome = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(itHome);
                finish();
            }
        });

        //entrar tela de registro

        this.btResgistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itResgistrar = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(itResgistrar);
                finish();
            }
        });

        //Login

        this.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etEmail.getText().toString().equals("abelinha") && etSenha.getText().toString().equals("123")){
                    Intent itMaps = new Intent(LoginActivity.this, MapsActivity.class);
                    startActivity(itMaps);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "tente de novo", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    //startar componentes

    private void start(){
        this.btLogin = findViewById(R.id.bt_login);
        this.btResgistrar = findViewById(R.id.bt_registrar);
        this.btVoltar = findViewById(R.id.bt_voltar);
        this.etEmail = findViewById(R.id.et_email);
        this.etSenha = findViewById(R.id.et_senha);
    }
}


