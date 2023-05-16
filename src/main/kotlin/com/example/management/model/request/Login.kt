package com.example.management.model.request

data class Login(
    val email: String?,
    val matricula: Long?,
    val pwd: String
)