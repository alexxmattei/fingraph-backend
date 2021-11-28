package com.example.services

import com.example.services.auth.AuthService
import com.example.services.auth.FingraphAuthService
import org.koin.dsl.module

val serviceModule = module {
    single<UserService> {
        FingraphUserService(get())
    }

    single<AuthService> {
        FingraphAuthService(get())
    }
}