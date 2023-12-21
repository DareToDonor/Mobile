package com.daaretodonor.di

import ApiConfig
import android.content.Context
import com.daaretodonor.data.Repository
import com.daaretodonor.model.UserPreference
import com.daaretodonor.model.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking


object Injection {
    fun provideRepository(context: Context): Repository {
        val pref = UserPreference.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService = ApiConfig.getApiService(user.token)
        return Repository.getInstance(pref, apiService)
    }
}