package com.example.corut.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.corut.api.ApiHelper
import com.example.corut.repository.MainRepository
import java.lang.IllegalArgumentException

class ViewModelFactory (private  val  apiHelper:ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(MainRepository(apiHelper))as T
        }
throw IllegalArgumentException("UNKOUN")
    }


}