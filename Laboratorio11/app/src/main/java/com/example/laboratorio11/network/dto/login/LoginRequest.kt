package com.example.laboratorio11.network.dto.login

import android.provider.ContactsContract.CommonDataKinds.Email

//Create LoginRequest data class
data class LoginRequest(
    //Add email and password fields
    val email: String,
    val password: String,
)