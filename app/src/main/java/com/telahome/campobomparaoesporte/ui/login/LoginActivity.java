package com.telahome.campobomparaoesporte.ui.login;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.telahome.campobomparaoesporte.MainActivity;
import com.telahome.campobomparaoesporte.R;
import com.telahome.campobomparaoesporte.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

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

    }
}


