package com.daaretodonor.data.api

import com.daaretodonor.data.response.login.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
        @POST("login")
        fun login(@Body request: LoginRequest): Call<LoginResponse>
}
data class LoginRequest(
    val email: String,
    val password: String
)





