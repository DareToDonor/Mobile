package com.daaretodonor.data

import ApiConfig
import com.daaretodonor.data.api.LoginRequest
import com.daaretodonor.data.response.login.LoginResponse
import retrofit2.await

class Repository {

    private val apiService = ApiConfig.createApiService()

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return apiService.login(loginRequest).await()
    }

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(): Repository =
            instance ?: synchronized(this) {
                Repository().apply {
                    instance = this
                }
            }
    }
}
