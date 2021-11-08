package com.example.controllers

import org.koin.dsl.module

val controllerModule = module {
    single {
        UserController(get())
    }
}