package com.example.plugins

import com.example.services.auth.AuthService
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.jwt.jwt
import org.koin.ktor.ext.getKoin


fun Application.configureAuthentication() {
    val authService = getKoin().get<AuthService>()

    install(Authentication) {
        jwt {
            verifier(authService.verifier)
            realm = "com.example"
            validate { credentials ->
                authService.validateUser(credentials.payload)
            }
        }
    }
}