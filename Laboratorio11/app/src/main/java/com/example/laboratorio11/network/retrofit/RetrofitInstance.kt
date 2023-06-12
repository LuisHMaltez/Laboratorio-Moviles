package com.example.laboratorio11.network.retrofit

import android.media.session.MediaSession.Token
import com.example.laboratorio11.network.service.AuthService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://retrofit.up.railway.app/"

object RetrofitInstance {

    //Create a variable to store the token
    private var token = ""

    //Create a function to set the token
    fun setToken(token: String) {
        this.token = token
    }

    //Create a instance of Retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //Create a function to get the login service from the Retrofit instance
    fun getLoginService(): AuthService {
        return retrofit.create(AuthService::class.java)
    }

}