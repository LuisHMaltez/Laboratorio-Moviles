package com.example.laboratorio11.network.dto.register

//Create RegisterRequest data class
data class RegisterRequest(
    //Add name, email and password fields
    val name: String,
    val email: String,
    val password: String,
)