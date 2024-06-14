package com.example.stage.utils

fun registerValidation(username : String , email : String , password : String , confirmpassword : String) : Boolean{

        val usernamePattern = Regex("^[a-zA-Z]{1,8}$")
        val usernameValid = usernamePattern.matches(username) && username.isNotEmpty()

        val accountValid = accountValidation(email, password)
        val passwordsMatch = password == confirmpassword

        return usernameValid && passwordsMatch && accountValid
}