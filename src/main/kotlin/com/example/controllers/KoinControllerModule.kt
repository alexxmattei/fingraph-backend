package com.example.controllers

import com.example.controllers.auth.AuthController
import org.koin.dsl.module

val controllerModule = module {
    single {
        UserController(get())
    }

    single {
        AuthController(get(), get())
    }

    single {
        TestController()
    }

    single {
        CoinGeckoController()
    }

    single {
        NomicsController()
    }
}