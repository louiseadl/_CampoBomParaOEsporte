package com.telahome.campobomparaoesporte.ui.Equipamentos;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.telahome.campobomparaoesporte.LoggedUsuario;
import com.telahome.campobomparaoesporte.Models.Equipamento;
import com.telahome.campobomparaoesporte.RetrofitCreator;
import com.telahome.campobomparaoesporte.Services.EquipamentosServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DeletarEquipamentos extends ListActivity {

    private EquipamentosServices service;
    private List<Equipamento> listaEquipamento;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        retrofit = RetrofitCreator.retrofit();
        service = retrofit.create(EquipamentosServices.class);

        //pega um arraylist com todos os equipamento que o usuario criou

        service.getEquipamentoUsuario(LoggedUsuario.getUsuario().getId()).enqueue(new Callback<ArrayList<Equipamento>>() {
            @Override
            public void onResponse(Call<ArrayList<Equipamento>> call, Response<ArrayList<Equipamento>> response) {
                if (response.isSuccessful()) {
                    listaEquipamento = response.body();
                    //e seta ela como array adapter da activity
                    ArrayAdapter<Equipamento> adapter = new ArrayAdapter<>(DeletarEquipamentos.this, android.R.layout.simple_list_item_1, listaEquipamento);
                    setListAdapter(adapter);
                } else {
                    Toast.makeText(DeletarEquipamentos.this, "erro", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Equipamento>> call, Throwable t) {
                Toast.makeText(DeletarEquipamentos.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();

            }
        });

    }

    //quando clicado em cima do equipamento ele é excluido

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        long idEquipamento = listaEquipamento.get(position).getId();
        service.deletar(idEquipamento).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(DeletarEquipamentos.this, "esporte excluído com sucesso!", Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(DeletarEquipamentos.this, "Não foi possível excluir o esporte selecionado. Tente novamente mais tarde!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(DeletarEquipamentos.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();
            }
        });
        finish();
    }

}



