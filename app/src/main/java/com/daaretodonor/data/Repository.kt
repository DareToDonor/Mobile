package com.daaretodonor.data

import ApiConfig
import com.daaretodonor.data.api.ApiService
import com.daaretodonor.data.api.LoginRequest
import com.daaretodonor.data.response.login.LoginResponse
import com.daaretodonor.model.UserModel
import com.daaretodonor.model.UserPreference
import retrofit2.await

class Repository private constructor(
    private val userPreference: UserPreference,
    private val apiService: ApiService
) {



    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return apiService.login(loginRequest).await()
    }
    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(userPreference: UserPreference, apiService: ApiService): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(userPreference, apiService)
            }.also { instance = it }
    }
}
