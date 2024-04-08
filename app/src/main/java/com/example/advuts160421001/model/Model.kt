package com.example.advuts160421001.model

data class CekUser(
    val result:String?,
    val id:String?
)

data class CekUsername(
    val result:String?
)

data class CekRegister(
    val result:String?
)

data class User(
    val id:String?,
    val username:String?,
    val firstname:String?,
    val lastname:String?,
    val email:String?,
    val password:String?
)