package com.telahome.campobomparaoesporte.Services;

import com.telahome.campobomparaoesporte.Models.Equipamento;
import com.telahome.campobomparaoesporte.Models.Local;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LocalServices {
    @POST("local/")
    Call<Local> setLocal(@Body Local local);

    @GET("local/{id}")
    Call<Local> getLocal(@Path("id") long id);

    @GET("local/")
    Call<ArrayList<Local>> getLocalTodos();

    @PUT("local/")
    Call<Local> atualizar(@Body Local local);

    @DELETE("local/{id}")
    Call<Boolean> deletar(@Path("id") long id);
}
