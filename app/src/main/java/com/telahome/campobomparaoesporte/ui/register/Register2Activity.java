package com.telahome.campobomparaoesporte.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.telahome.campobomparaoesporte.Models.Usuario;
import com.telahome.campobomparaoesporte.R;
import com.telahome.campobomparaoesporte.RetrofitCreator;
import com.telahome.campobomparaoesporte.Services.UsuarioServices;
import com.telahome.campobomparaoesporte.ui.login.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


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
                UsuarioServices service = retrofit.create(UsuarioServices.class);
                service.setUsuario(usuario).enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(response.isSuccessful()) {
                            Toast.makeText(Register2Activity.this, "Usuario cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Register2Activity.this, "Falha no cadastro, tente novamente mais tarde!", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(Register2Activity.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();
                    }
                });

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
