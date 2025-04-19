package com.example.motivation

class UserBusiness {

    fun checkCredentials(nameUser: String): Boolean{
        return nameUser.isNotEmpty()
    }
}