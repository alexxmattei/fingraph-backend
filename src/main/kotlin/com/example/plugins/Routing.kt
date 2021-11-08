package com.example.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import com.example.repositories.*
import com.example.controllers.*
import org.koin.java.KoinJavaComponent.getKoin

fun Application.configureRouting() {

    val userController = getKoin().get<UserController>()

    routing {
        route("/api") {
            route("/v1") {
                 userController.addRoutes(this)
            }
        }
    }
}

