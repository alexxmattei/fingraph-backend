package com.example.services

import org.koin.dsl.module

val serviceModule = module {
    single<UserService> {
        FingraphUserService(get())
    }
}