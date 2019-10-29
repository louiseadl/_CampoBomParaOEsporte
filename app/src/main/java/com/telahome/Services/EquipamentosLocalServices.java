package com.telahome.campobomparaoesporte.Services;

import com.telahome.campobomparaoesporte.Models.Equipamento;
import com.telahome.campobomparaoesporte.Models.Esporte;
import com.telahome.campobomparaoesporte.Models.Local;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EquipamentosLocalServices {

    @POST("equipamentoslocal/")
    Call<Boolean> setEquipamentosLocal(@Body Local local, @Body Equipamento equipamento);

    @GET("equipamentoslocal/equipamento")
    Call<ArrayList<Equipamento>> getEquipamento(@Body Local local);

    @GET("equipamentoslocal/local")
    Call<ArrayList<Local>> getLocal(@Body Equipamento equipamento);

    @DELETE("equipamentoslocal/")
    Call<Boolean> deletar(@Body Local local, @Body Equipamento equipamento);

}
