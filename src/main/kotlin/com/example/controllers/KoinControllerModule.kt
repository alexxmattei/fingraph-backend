package com.example.controllers

import com.example.controllers.auth.AuthController
import org.koin.dsl.module

val controllerModule = module {
    single {
        AuthController(get(), get())
    }

    single {
        UserController(get())
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