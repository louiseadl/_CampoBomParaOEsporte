package com.telahome.campobomparaoesporte.ui.criarEsportes;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
        retrofit = RetrofitCreator.retrofit();
        service.getEsporteUsuario(LoggedUsuario.getUsuario().getId()).enqueue(new Callback<ArrayList<Esporte>>() {
            @Override
            public void onResponse(Call <ArrayList<Esporte>> call, Response<ArrayList<Esporte>> response) {
                if (response.isSuccessful()) {
                    listaEsporte = response.body();
                    ArrayAdapter<Esporte> adapter = new ArrayAdapter<>(DeletarEsporte.this, android.R.layout.simple_list_item_1,listaEsporte);
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
}
