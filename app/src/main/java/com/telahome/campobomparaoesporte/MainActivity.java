package com.telahome.campobomparaoesporte;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.telahome.campobomparaoesporte.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    //declarar componentes

    private Button btLogin;
    private Button btMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        start();


        //maps

        this.btMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itTelaMaps = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(itTelaMaps);
            }
        });

        //login

        this.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itTelaLogin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(itTelaLogin);
            }
        });

    }

    //startar componentes

    private void start(){
        this.btLogin = findViewById(R.id.bt_login);
        this.btMaps = findViewById(R.id.bt_entrar_sem_login);
    }
}