package com.example.stage.domain.repository

import androidx.lifecycle.MutableLiveData
import com.example.stage.domain.entity.User

interface IAuth {
    fun login (user: User) : MutableLiveData<Boolean>
    fun register (user: User) : MutableLiveData<Boolean>
}