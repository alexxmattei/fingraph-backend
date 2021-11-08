package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    var id: String = "",
    var email: String = "",
    var password: String = "",
    var fullName: String = "",
    var callingName: String = ""
)

data class UserLogin(val email: String, val password: String)