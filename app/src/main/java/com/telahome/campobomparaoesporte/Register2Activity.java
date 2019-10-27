package com.telahome.campobomparaoesporte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.telahome.campobomparaoesporte.ui.login.LoginActivity;

public class Register2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        Button bbt_return = (Button) findViewById(R.id.bbt_return);

        // botão de voltar

        bbt_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(Register2Activity.this, LoginActivity.class);
                startActivity(voltar);
                finish();
            }
        });
    }}