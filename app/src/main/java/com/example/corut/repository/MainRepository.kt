package com.example.corut.repository

import com.example.corut.api.ApiHelper

class MainRepository(private  val apiHelper: ApiHelper) {
    suspend fun getUsers()=apiHelper.getUsers()
}