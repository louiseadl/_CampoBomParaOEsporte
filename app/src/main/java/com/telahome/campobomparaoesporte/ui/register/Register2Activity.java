package com.telahome.campobomparaoesporte.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.telahome.campobomparaoesporte.Models.Usuario;
import com.telahome.campobomparaoesporte.R;
import com.telahome.campobomparaoesporte.RetrofitCreator;
import com.telahome.campobomparaoesporte.Services.UsuarioServices;
import com.telahome.campobomparaoesporte.ui.login.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Register2Activity extends AppCompatActivity {

    private Button btCadastrar;
    private Button btVoltar;
    private EditText etNome;
    private EditText etEmail;
    private EditText etSenha;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        start();

        this.btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(Register2Activity.this, LoginActivity.class);
                startActivity(voltar);
            }
        });


        this.btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario();
                usuario.setEmail(etEmail.getText().toString());
                usuario.setNome(etNome.getText().toString());
                usuario.setSenha(etSenha.getText().toString());

            }
        });


    }

    private void start(){
        this.btCadastrar = findViewById(R.id.bt_Reegistrar);
        this.btVoltar = findViewById(R.id.bbt_return);
        this.etEmail = findViewById(R.id.et_email3);
        this.etSenha = findViewById(R.id.et_senha3);
        this.etNome = findViewById(R.id.et_nome3);
        retrofit = RetrofitCreator.retrofit();
    }
}
