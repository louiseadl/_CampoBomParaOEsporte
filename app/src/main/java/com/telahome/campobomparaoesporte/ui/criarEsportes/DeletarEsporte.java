package com.telahome.campobomparaoesporte.ui.criarEsportes;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.telahome.campobomparaoesporte.LoggedUsuario;
import com.telahome.campobomparaoesporte.Models.Esporte;
import com.telahome.campobomparaoesporte.RetrofitCreator;
import com.telahome.campobomparaoesporte.Services.EsportesServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

    public class DeletarEsporte extends ListActivity {

    private EsportesServices service;
    private List<Esporte> listaEsporte;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = retrofit.create(EsportesServices.class);
        retrofit = RetrofitCreator.retrofit();

        //pega uma list com todos as esporte criados pelo esporte

        service.getEsporteUsuario(LoggedUsuario.getUsuario().getId()).enqueue(new Callback<ArrayList<Esporte>>() {
            @Override
            public void onResponse(Call<ArrayList<Esporte>> call, Response<ArrayList<Esporte>> response) {
                if (response.isSuccessful()) {
                    listaEsporte = response.body();
                    //e seta ela como adapter da list activity
                    ArrayAdapter<Esporte> adapter = new ArrayAdapter<>(DeletarEsporte.this, android.R.layout.simple_list_item_1, listaEsporte);
                    setListAdapter(adapter);
                } else {
                    Toast.makeText(DeletarEsporte.this, "erro", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Esporte>> call, Throwable t) {
                Toast.makeText(DeletarEsporte.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();

            }
        });

    }

        //quando clicar um um item da list activity ele o deleta

        @Override
        protected void onListItemClick(ListView l, View v, int position, long id) {
            super.onListItemClick(l, v, position, id);
                long idEsporte = listaEsporte.get(position).getId();
                service.deletar(idEsporte).enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if(response.isSuccessful()) {
                            Toast.makeText(DeletarEsporte.this, "esporte excluído com sucesso!", Toast.LENGTH_LONG).show();
                            finish();
                        }else {
                            Toast.makeText(DeletarEsporte.this, "Não foi possível excluir o esporte selecionado. Tente novamente mais tarde!", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Toast.makeText(DeletarEsporte.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();
                    }
                });
                finish();
            }

    }

