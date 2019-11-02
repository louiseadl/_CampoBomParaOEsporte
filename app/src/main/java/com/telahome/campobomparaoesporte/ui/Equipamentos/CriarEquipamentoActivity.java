package com.telahome.campobomparaoesporte.ui.Equipamentos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.telahome.campobomparaoesporte.Models.Equipamento;
import com.telahome.campobomparaoesporte.R;
import com.telahome.campobomparaoesporte.RetrofitCreator;
import com.telahome.campobomparaoesporte.Services.EquipamentosServices;
import com.telahome.campobomparaoesporte.ui.criarEsportes.EsportesMainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CriarEquipamentoActivity extends AppCompatActivity {

    private Button btVoltar;
    private Button btCriar;
    private EditText etNome;
    private EditText etDescricao;
    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_equipamento);
        start();

        //volta para tela anterior

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itVoltar = new Intent(CriarEquipamentoActivity.this, EsportesMainActivity.class);
                startActivity(itVoltar);
            }
        });

        //cria um equipamento e salva ele no banco

        btCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Equipamento equipamento = new Equipamento(etNome.getText().toString(), etDescricao.getText().toString());
                EquipamentosServices service = retrofit.create(EquipamentosServices.class);
                service.setEquipamento(equipamento).enqueue(new Callback<Equipamento>() {
                    @Override
                    public void onResponse(Call<Equipamento> call, Response<Equipamento> response) {
                        if(response.isSuccessful()) {
                            Toast.makeText(CriarEquipamentoActivity.this, "equipamento cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                            Intent itVoltar = new Intent(CriarEquipamentoActivity.this, EsportesMainActivity.class);
                            startActivity(itVoltar);
                        } else {
                            Toast.makeText(CriarEquipamentoActivity.this, "Falha no cadastro, tente novamente mais tarde!", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Equipamento> call, Throwable t) {
                        Toast.makeText(CriarEquipamentoActivity .this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }

    private void start(){
        btVoltar = findViewById(R.id.bt_voltar_equipamentos_main);
        btCriar = findViewById(R.id.bt_criar_equipamento_main);
        etDescricao = findViewById(R.id.id_descricao_equipamento);
        etNome = findViewById(R.id.id_nome_equipamento);
        retrofit = RetrofitCreator.retrofit();
    }
}
