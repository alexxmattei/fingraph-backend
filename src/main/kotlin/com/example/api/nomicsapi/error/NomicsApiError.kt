package com.example.api.nomicsapi.error

data class NomicsApiError(
    val code: Int = 0,
    val message: String? = null
)