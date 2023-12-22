package com.daaretodonor.data.response.user

data class UserResponse(
    val status: String,
    val message: String,
    val data: User?
)

data class User(
    val id: Int,
    val idDonor: Int?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val dateOfBirth: String?,
    val NIK: String?,
    val phoneNumber: String,
    val bloodType: String?,
    val address: String?,
    val imageProfile: String?,
    val role: String
)
