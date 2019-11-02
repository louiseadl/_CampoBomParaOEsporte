package com.telahome.campobomparaoesporte.ui.criarEsportes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.telahome.campobomparaoesporte.Models.Esporte;
import com.telahome.campobomparaoesporte.Models.Usuario;
import com.telahome.campobomparaoesporte.R;
import com.telahome.campobomparaoesporte.RetrofitCreator;
import com.telahome.campobomparaoesporte.Services.EsportesServices;
import com.telahome.campobomparaoesporte.ui.register.Register2Activity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CriarEsporteActivity extends AppCompatActivity {

    private Button btCadastar;
    private Button btVoltar;
    private EditText etNome;
    private EditText etDescricao;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_esporte);
        start();

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itVoltar = new Intent(CriarEsporteActivity.this,EsportesMainActivity.class);
                startActivity(itVoltar);
            }
        });

        btCadastar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Esporte esporte = new Esporte(etNome.getText().toString(), etDescricao.getText().toString());
                EsportesServices service = retrofit.create(EsportesServices.class);
                service.setEsportes(esporte).enqueue(new Callback<Usuario>() {
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
        btCadastar= findViewById(R.id.bt_cadastrar_esportee);
        btVoltar=findViewById(R.id.bt_voltar_criar_esporte);
        etDescricao=findViewById(R.id.et_descricao_esporte);
        etNome=findViewById(R.id.et_nome_esporte);
        retrofit= RetrofitCreator.retrofit();
    }
}
