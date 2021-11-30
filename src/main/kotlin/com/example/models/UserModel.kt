package com.example.models

import io.ktor.auth.*
import kotlinx.serialization.Serializable

@Serializable
data class User(
    var id: Int = -1,
    var email: String = "",
    var password: String = "",
    var fullName: String = "",
    var callingName: String = ""
) : Principal

@Serializable
data class UserLogin(val email: String, val password: String)