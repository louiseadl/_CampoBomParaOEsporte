package com.telahome.campobomparaoesporte.Services;

import com.telahome.campobomparaoesporte.Models.Usuario;



import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UsuarioServices {


    @POST("usuario/")
    Call<Usuario> setUsuario(@Body Usuario usuario);

    @GET("usuario/{id}")
    Call<Usuario> getUsuario(@Path("id") long id);

    @GET("usuario/{email}/{senha}")
    Call<Usuario> login(@Path("email") String email,@Path("senha") String senha);

    @PUT("usuario/")
    Call<Usuario> atualizar(@Body Usuario usuario);

    @DELETE("usuario/{id}")
    Call<Boolean> deletar(@Path("id") long id);



}
