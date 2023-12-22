package com.daaretodonor.data.response.locationhospital



data class LocationResponse(
    val status: String,
    val message: String,
    val getLocations: List<Location>
)

data class Location(
    val id: Int,
    val name: String,
    val city: String,
    val province: String,
    val address: String,
    val status: Boolean,
    val image: String,
    val createdAt: String,
    val updatedAt: String
)



