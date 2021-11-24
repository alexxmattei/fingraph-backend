package com.example.models.dto

import com.example.config.JwtConfig
import kotlinx.serialization.Serializable

@Serializable
data class RecoveryRequestResponse(var url: String = "") {
    fun createURL(id: String) {
        url = "${JwtConfig.domain}reset_pass?token=$id"
    }
}
