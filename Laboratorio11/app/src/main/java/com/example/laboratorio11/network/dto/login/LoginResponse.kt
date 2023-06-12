package com.example.laboratorio11.network.dto.login

import com.google.gson.annotations.SerializedName

//Create LoginRequest data class
data class LoginResponse(
    // Specify the name of the fields in the JSON response
    @SerializedName("msg") val message: String,
    @SerializedName("token") val token: String,
)