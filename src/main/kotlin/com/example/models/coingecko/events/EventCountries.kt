package com.example.models.coingecko.events

import kotlinx.serialization.Serializable

@Serializable
data class EventCountries(
    val data: List<EventCountryData> = emptyList(),
    val count: Int
)