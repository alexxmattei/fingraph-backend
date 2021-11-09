package com.example.models.coingecko.events

import kotlinx.serialization.Serializable

@Serializable
data class EventCountryData(
    val country: String,
    val code: String
)