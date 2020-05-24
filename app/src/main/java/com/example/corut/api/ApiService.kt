package com.example.corut.api

import com.example.corut.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers():List<User>
}