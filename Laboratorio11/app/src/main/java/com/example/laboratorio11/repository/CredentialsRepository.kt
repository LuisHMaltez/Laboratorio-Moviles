package com.example.laboratorio11.repository

import android.provider.ContactsContract.CommonDataKinds.Email
import com.example.laboratorio11.network.ApiResponse
import com.example.laboratorio11.network.dto.login.LoginRequest
import com.example.laboratorio11.network.dto.register.RegisterRequest
import com.example.laboratorio11.network.service.AuthService
import retrofit2.HttpException
import java.io.IOException

class CredentialsRepository(private val api: AuthService) {

    //Create a function to login using the AuthService and return an ApiResponse
    suspend fun login(email: String, password: String): ApiResponse<String> {
        try {

            val response = api.login(LoginRequest(email, password))
            return ApiResponse.Success(response.token)
        } catch (e: HttpException){
            if (e.code() == 400) {
                return ApiResponse.ErrorWithMessage("Invalid email or password")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }

    //Create a function to register using the AuthService and return an ApiResponse
    suspend fun register(name: String, email: String, password: String): ApiResponse<String>{
        try{
            val response = api.register(RegisterRequest(name = name, email = email, password = password))
            return ApiResponse.Success(response.message)

        } catch (e: HttpException){

            if(e.code() == 400){
                return ApiResponse.ErrorWithMessage("Invalid fields, name, email or password")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException){
            return ApiResponse.Error(e)

        }
    }
}