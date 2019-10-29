package com.telahome.campobomparaoesporte.Services;

import com.telahome.campobomparaoesporte.Models.Pin;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PinServices {

    @GET("pin/{id}")
    Call<Pin> getPin(@Path("id") long id);

    @GET("pin/")
    Call<ArrayList<Pin>> getPinTodos();

}
