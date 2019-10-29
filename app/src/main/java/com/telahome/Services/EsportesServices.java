package com.telahome.campobomparaoesporte.Services;

import com.telahome.campobomparaoesporte.Models.Equipamento;
import com.telahome.campobomparaoesporte.Models.Esporte;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EsportesServices {

    @POST("esportes/")
    Call<Esporte> setEsportes(@Body Esporte esporte);

    @GET("esportes/{id}")
    Call<Esporte> getEsporte(@Path("id") long id);

    @GET("esportes/")
    Call<ArrayList<Esporte>> getEsporteTodos();

    @PUT("esportes/")
    Call<Esporte> atualizar(@Body Esporte esporte);

    @DELETE("esportes/{id}")
    Call<Boolean> deletar(@Path("id") long id);
}
