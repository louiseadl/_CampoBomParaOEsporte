package com.telahome.campobomparaoesporte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.telahome.campobomparaoesporte.ui.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        Button bt_voltar = (Button) findViewById(R.id.bt_voltar);

        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent itTelaHome= new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(itTelaHome);


            }
        });






        Button bt_register = (Button) findViewById(R.id.bt_register);

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView et_nome = (TextView) findViewById(R.id.et_nome);
                TextView et_email =  (TextView) findViewById(R.id.et_email);
                TextView et_senha = (TextView) findViewById(R.id.et_senha);


                String nome = et_nome.getText().toString();
                String email = et_email.getText().toString();
                String senha = et_senha.getText().toString();

                if (nome.equals("")&& senha.equals("") && email.equals("")){
                    alert("Não registrado");

                } else{
                    alert("Registrado");
                }


            }
        });
    }

    private void alert (String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

}
