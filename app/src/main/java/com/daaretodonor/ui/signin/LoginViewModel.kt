package com.daaretodonor.ui
import ApiConfig
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daaretodonor.data.api.ApiService
import com.daaretodonor.data.api.LoginRequest
import com.daaretodonor.data.response.login.LoginResponse
import kotlinx.coroutines.launch
import retrofit2.await

class LoginViewModel : ViewModel() {
    private val _loginResponse = MutableLiveData<LoginResponse>()
    val loginResponse: LiveData<LoginResponse>
        get() = _loginResponse
    private val apiService: ApiService by lazy {
        ApiConfig.createApiService()
    }
    fun login() {
        val loginRequest = LoginRequest(
            email = "mochamdramdhann@gmail.com",
            password = "ApapunBisa1"
        )

        viewModelScope.launch {
            try {
                val response = apiService.login(loginRequest).await()
                _loginResponse.value = response
            } catch (e: Exception) {
            }
        }
    }
}
