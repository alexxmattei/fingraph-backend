package com.example.plugins

import io.ktor.routing.*
import io.ktor.application.*
import com.example.controllers.*
import org.junit.Test
import org.koin.java.KoinJavaComponent.getKoin

fun Application.configureRouting() {

    val userController = getKoin().get<UserController>()
    val testController = getKoin().get<TestController>()
    val coinGeckoController = getKoin().get<CoinGeckoController>()

    routing {
        route("/api") {
            route("/v1") {
                 userController.addRoutes(this)
                 testController.addRoutes(this)
                 coinGeckoController.addRoutes(this)
            }
        }
    }
}

