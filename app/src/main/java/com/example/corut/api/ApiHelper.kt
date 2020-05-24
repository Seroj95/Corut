package com.example.corut.api

class ApiHelper (private val apiService: ApiService) {
    suspend fun getUsers()=apiService.getUsers()
}