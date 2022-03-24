package com.example.fourpay.retrofit;

import com.example.fourpay.model.Conta;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitMethods {

    @GET("login/{email}/{senha}")
    Call<Conta> contaLogin(@Path("email") String email, @Path("senha") String senha);

    @GET("contas/read/{id}")
    Call<Conta> contaGet(@Path("id") Long id);

    @POST("contas/create")
    Call<Conta> contaPost(@Body Conta conta);
}


