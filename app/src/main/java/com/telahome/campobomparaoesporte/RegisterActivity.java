package com.telahome.campobomparaoesporte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.telahome.campobomparaoesporte.ui.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    //desclarar componentes

    private Button btResgistrar;
    private Button btVoltar;
    private EditText etNome;
    private EditText etEmail;
    private EditText etSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //voltar para login

        this.btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itRegister = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(itRegister);
            }
        });

        //registrar conta

        this.btResgistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Usuario novo = new Usuario();
                novo.setNome(etNome.getText().toString());
                novo.setSenha(etSenha.getText().toString());
                novo.setEmail(etEmail.getText().toString());

                //manda o usuario pro servidor por meio do post /usuario/

                 */

                Intent itLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(itLogin);
            }
        });


    }

    //startar componentes

    public void start(){
        this.btResgistrar.findViewById(R.id.bt_registrar_registrar);
        this.btVoltar.findViewById(R.id.bt_voltar_registrar);
        this.etSenha.findViewById(R.id.et_senha_registrar);
        this.etEmail.findViewById(R.id.et_email_registro);
        this.etNome.findViewById(R.id.et_nome_resgistro);

    }

}