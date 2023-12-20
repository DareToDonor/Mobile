package com.daaretodonor.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daaretodonor.data.Repository
import com.daaretodonor.data.api.LoginRequest
import com.daaretodonor.data.response.login.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: Repository) : ViewModel() {

    private val _loginSuccess = MutableLiveData<LoginResponse>()
     val loginSuccess: LiveData<LoginResponse>
        get() = _loginSuccess

    private val _loginError = MutableLiveData<String>()
    private val loginError: LiveData<String>
        get() = _loginError

    fun login(email: String, password: String) {
        val loginRequest = LoginRequest(
            email = email,
            password = password
        )

        viewModelScope.launch {
            try {
                val response = repository.login(loginRequest)
                _loginSuccess.value = response
            } catch (e: Exception) {
                // Handle error
                _loginError.value = e.message
            }
        }
    }
}
