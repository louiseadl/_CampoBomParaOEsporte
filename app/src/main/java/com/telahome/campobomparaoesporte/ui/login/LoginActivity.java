package com.telahome.campobomparaoesporte.ui.login;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.telahome.campobomparaoesporte.LoggedUsuario;
import com.telahome.campobomparaoesporte.MainActivity;
import com.telahome.campobomparaoesporte.Main_LoginMapsActivity;
import com.telahome.campobomparaoesporte.Models.Usuario;
import com.telahome.campobomparaoesporte.R;
import com.telahome.campobomparaoesporte.RetrofitCreator;
import com.telahome.campobomparaoesporte.Services.UsuarioServices;
import com.telahome.campobomparaoesporte.ui.register.Register2Activity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {

    //declarar componentes

    private Button btVoltar;
    private Button btLogin;
    private Button btResgistrar;
    private EditText etEmail;
    private EditText etSenha;
    private Retrofit retrofit;
    private Usuario usuario;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        start();

        btResgistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TelaRegister= new Intent(LoginActivity.this, Register2Activity.class);
                startActivity(TelaRegister);
                finish();
            }
        });

        //voltar pra home

        this.btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itHome = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(itHome);
                finish();
            }
        });


        //Login

        this.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                UsuarioServices service = retrofit.create(UsuarioServices.class);
                service.login(etEmail.getText().toString(), etSenha.getText().toString()).enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if (response.isSuccessful()) {
                            usuario = response.body();
                        if(usuario.getId() != 0 ){
                            LoggedUsuario.setUsuario(usuario);
                                Intent itMaps = new Intent(LoginActivity.this, Main_LoginMapsActivity.class);
                                startActivity(itMaps);
                            }else{
                                Toast.makeText(LoginActivity.this, "email/senha errados", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, "email/senha errados", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();
                        if (etEmail.getText().toString().equals("aelinha") && etSenha.getText().toString().equals("123")){

                        }
                    }
                });

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
        retrofit = RetrofitCreator.retrofit();
    }
}