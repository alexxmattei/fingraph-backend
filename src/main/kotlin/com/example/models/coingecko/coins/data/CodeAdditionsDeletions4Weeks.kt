package com.example.models.coingecko.coins.data

import kotlinx.serialization.Serializable

@Serializable
data class CodeAdditionsDeletions4Weeks(
    val additions: Long = 0,
    val deletions: Long = 0
)