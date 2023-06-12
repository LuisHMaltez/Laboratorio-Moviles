package com.example.laboratorio11.network.dto.register

import com.google.gson.annotations.SerializedName

//Create RegisterResponse data class
data class RegisterResponse(
    //Specify the name of the fields in the JSON response
    @SerializedName("msg") val message: String,
)