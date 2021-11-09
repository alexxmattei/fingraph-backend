package com.example.models.coingecko.events

import kotlinx.serialization.Serializable

@Serializable
data class Events(
    val data: List<EventData>,
    val count: Long = 0,
    val page: Long = 0
)