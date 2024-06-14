package com.example.stage.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stage.data.repository.AuthRepository
import com.example.stage.domain.entity.User

class AuthVM : ViewModel() {
    lateinit var repository: AuthRepository

    init {
        repository = AuthRepository()
    }

    fun login(email: String, password: String): MutableLiveData<Boolean> {
        return repository.login(User(email, password))
    }

    lateinit var repository2: AuthRepository
    fun register(email: String, password: String): MutableLiveData<Boolean> {

        return repository.register(User(email, password))
    }

}