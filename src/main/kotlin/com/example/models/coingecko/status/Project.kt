package com.example.models.coingecko.status

import com.example.models.coingecko.shared.Image
import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val type: String? = null,
    val id: String? = null,
    val name: String? = null,
    val symbol: String? = null,
    val image: Image? = null
)