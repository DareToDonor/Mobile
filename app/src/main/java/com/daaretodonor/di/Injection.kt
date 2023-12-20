package com.daaretodonor.di

import com.daaretodonor.data.Repository


object Injection {
    fun provideRepository(): Repository {
        return Repository.getInstance()
    }
}
