package com.example.corut.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.corut.Utils.Resource
import com.example.corut.repository.MainRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel (private val mainRepository: MainRepository) : ViewModel() {
    fun getUsers()= liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.succes(data = mainRepository.getUsers()))
        }catch (exeption:Exception){
            emit(Resource.error(data = null,message = exeption.message?:"Error Ocured"))
        }
    }
}