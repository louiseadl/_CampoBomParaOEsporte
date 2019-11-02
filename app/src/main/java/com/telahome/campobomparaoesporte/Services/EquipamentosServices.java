package com.telahome.campobomparaoesporte.Services;

import com.telahome.campobomparaoesporte.Models.Equipamento;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface EquipamentosServices {

    @POST("equipamentos/")
    Call<Equipamento> setEquipamento(@Body Equipamento equipamento);

    @GET("equipamentos/{id}")
    Call<Equipamento> getEquipamento(@Path("id") long id);

    @GET("equipamentos/usuario/{id}")
    Call<ArrayList<Equipamento>> getEquipamentoUsuario(@Path("id") long id);

    @GET("equipamentos/")
    Call<ArrayList<Equipamento>> getEquipamentoTodos();

    @PUT("equipamentos/")
    Call<Equipamento> atualizar(@Body Equipamento equipamento);

    @DELETE("equipamentos/{id}")
    Call<Boolean> deletar(@Path("id") long id);

}
