package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class PasswordRecoveryEntry(
    val id: String = "",
    val email: String = "",
    val expirationDate: String = ""
)