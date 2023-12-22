package com.daaretodonor.data.api

import com.daaretodonor.data.response.locationhospital.LocationResponse
import com.daaretodonor.data.response.login.LoginResponse
import com.daaretodonor.data.response.user.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
    @GET("users")
    suspend fun getUserData(): UserResponse
    @GET("donors/locations")
    suspend fun getLocations(): Response<LocationResponse>

}

data class LoginRequest(
    val email: String,
    val password: String
)





