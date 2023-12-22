package com.daaretodonor.data

import com.daaretodonor.data.api.ApiService
import com.daaretodonor.data.api.LoginRequest
import com.daaretodonor.data.response.locationhospital.Location
import com.daaretodonor.data.response.login.LoginResponse
import com.daaretodonor.data.response.user.User
import com.daaretodonor.model.UserModel
import com.daaretodonor.model.UserPreference
import com.daaretodonor.ui.common.Resource
import kotlinx.coroutines.flow.first
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
    suspend fun getUserData(): User? {
        val token = userPreference.getSession().first().token
        return apiService.getUserData().data
    }

    suspend fun getLocations(): Resource<List<Location>> {
        return try {
            val response = apiService.getLocations()
            if (response.isSuccessful) {
                Resource.Success(response.body()?.getLocations ?: emptyList())
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
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
