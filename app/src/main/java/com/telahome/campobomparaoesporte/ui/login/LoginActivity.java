package com.telahome.campobomparaoesporte.ui.login;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.telahome.campobomparaoesporte.MainActivity;
import com.telahome.campobomparaoesporte.MapsActivity;
import com.telahome.campobomparaoesporte.R;
import com.telahome.campobomparaoesporte.RegisterActivity;



public class LoginActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    //---------------------------- VOLTAR ----------------------------
        Button bt_voltar = (Button) findViewById(R.id.bt_voltar);

        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent itTelaHome= new Intent(LoginActivity.this, MainActivity.class);
                startActivity(itTelaHome);


            }
        });
        //---------------------------- REGISTER ----------------------------

        Button bt_register = (Button) findViewById(R.id.bt_register);

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent itTelaRegister= new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(itTelaRegister);



            }
        });
        //----------------------------------------------------------

        TextView et_email =  (TextView) findViewById(R.id.et_email);
        TextView et_senha = (TextView) findViewById(R.id.et_senha);

        String email = et_email.getText().toString();
        String senha = et_senha.getText().toString();

        if (email.equals("abelinha")&& senha.equals("123")){

            Intent itTelaMapa = new Intent(LoginActivity.this, MapsActivity.class);
            startActivity(itTelaMapa);

        } else{

            Intent itTelaLogin= new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(itTelaLogin);




        }
    }
}


