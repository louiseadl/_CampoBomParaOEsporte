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

public interface EquipamentosEsportesServices {

    @POST("equipamentosesportes/")
    Call<Boolean> setEquipamentosEsportes(@Body Esporte esporte, @Body Equipamento equipamento);

    @GET("equipamentosesportes/equipamento")
    Call<ArrayList<Equipamento>> getEquipamento(@Body Esporte esporte);

    @GET("equipamentosesportes/esporte")
    Call<ArrayList<Esporte>> getEsporte(@Body Equipamento equipamento);

    @DELETE("equipamentosesportes/")
    Call<Boolean> deletar(@Body Esporte esporte, @Body Equipamento equipamento);
}
