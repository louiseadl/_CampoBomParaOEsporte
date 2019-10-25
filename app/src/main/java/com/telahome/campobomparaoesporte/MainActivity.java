package com.telahome.campobomparaoesporte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.telahome.campobomparaoesporte.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        //Declarando botões

        //bt_login

        Button bt_entrarLogin = (Button) findViewById(R.id.bt_entrarLogin);

        bt_entrarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itTelaMapa = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(itTelaMapa);


            }
        });

        //bt maps

        Button bt_entrarsemLogin =(Button) findViewById(R.id.bt_entrarsemLogin);

        bt_entrarsemLogin.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent itTelaLogin= new Intent(MainActivity.this, LoginActivity.class);
                startActivity(itTelaLogin);


            }
        }));

    }

}