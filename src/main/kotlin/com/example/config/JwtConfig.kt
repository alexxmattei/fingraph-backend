package com.example.config

import com.auth0.jwt.algorithms.Algorithm

object JwtConfig {
    private val secret: String = System.getenv("secret") ?: "abcxyz"
    const val domain = "https://www.fingraph-app.com/"
    val audience = "http://0.0.0.0:${System.getenv("port") ?: 8080}"
    const val validityInMs = 86_400_000
    val algorithm: Algorithm = Algorithm.HMAC512(secret)
}