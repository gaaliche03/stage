package com.example.stage.utils

fun accountValidation(email:String, password : String) : Boolean {

    val emailValid = email.isNotEmpty() && email.contains("@") && email.endsWith(".com")
    val passwordValid = password.isNotEmpty() && password.length in 8..12

    return emailValid && passwordValid
}