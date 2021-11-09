package com.example.models.coingecko.rates

import kotlinx.serialization.Serializable

@Serializable
data class Rate(
    val name: String,
    val unit: String,
    val value: Long = 0,
    val type: String
)