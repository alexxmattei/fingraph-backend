package com.example.plugins

import io.ktor.routing.*
import io.ktor.application.*
import com.example.controllers.*
import com.example.controllers.auth.AuthController
import org.junit.Test
import org.koin.java.KoinJavaComponent.getKoin

fun Application.configureRouting() {

    val userController = getKoin().get<UserController>()
    val authController = getKoin().get<AuthController>()
    val testController = getKoin().get<TestController>()
    val coinGeckoController = getKoin().get<CoinGeckoController>()
    val nomicsController = getKoin().get<NomicsController>()

    routing {
        route("/api") {
            route("/v1") {
                 authController.addRoutes(this)
                 userController.addRoutes(this)
                 testController.addRoutes(this)
                 coinGeckoController.addRoutes(this)
                 nomicsController.addRoutes(this)
            }
        }
    }
}

