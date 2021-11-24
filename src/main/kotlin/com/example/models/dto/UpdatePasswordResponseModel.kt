package com.example.models.dto

import kotlinx.serialization.Serializable

@Serializable
data class NewPasswordResponse(
    val id: String = "",
    val password: String = ""
)
