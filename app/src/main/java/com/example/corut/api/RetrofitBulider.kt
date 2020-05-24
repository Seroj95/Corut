package com.example.corut.api

import com.example.corut.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBulider {
private fun getRetrofit() : Retrofit{
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
    val apiService:ApiService= getRetrofit().create(ApiService::class.java)
}