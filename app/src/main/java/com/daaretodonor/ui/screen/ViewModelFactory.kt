package com.daaretodonor.ui.screen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daaretodonor.data.Repository
import com.daaretodonor.ui.LoginViewModel
import com.daaretodonor.ui.screen.donor.DonorViewModel


class ViewModelFactory(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository) as T
        }else if (modelClass.isAssignableFrom(DonorViewModel::class.java)) {
            return DonorViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}
