package com.daaretodonor.ui.screen.donor

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daaretodonor.data.Repository
import com.daaretodonor.data.response.locationhospital.Location
import com.daaretodonor.ui.common.Resource
import kotlinx.coroutines.launch

class DonorViewModel(private val repository: Repository) : ViewModel() {

    private val _locations = mutableStateOf<List<Location>>(emptyList())
    val locations: State<List<Location>> = _locations

    fun getLocations() {
        viewModelScope.launch {
            val result = repository.getLocations()
            when (result) {
                is Resource.Success -> {
                    val locations = result.data
                    _locations.value = locations
                }
                is Resource.Error -> {
                    val errorMessage = result.message

                }
                is Resource.Loading -> {
                }
            }
        }
    }
}

