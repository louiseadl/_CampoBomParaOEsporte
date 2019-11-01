package com.telahome.campobomparaoesporte.Services;

import com.telahome.campobomparaoesporte.Models.Esporte;
import com.telahome.campobomparaoesporte.Models.Local;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LocalEsporteServices {
    @POST("localesportes/")
    Call<Boolean> setLocalEsporte(@Body Esporte esporte, @Body Local local);

    @GET("localesportes/esporte")
    Call<ArrayList<Esporte>> getEsporte(@Body Local local);

    @GET("localesportes/local")
    Call<ArrayList<Local>> getLocal(@Body Esporte esporte);

    @DELETE("localesportes/")
    Call<Boolean> deletar(@Body Esporte esporte, @Body Local local);
}
