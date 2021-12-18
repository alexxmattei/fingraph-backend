package com.example

import com.example.config.DBConfig
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureHeaders()
        configureCORS()
        configureKoin()
        configureAuthentication()
        configureStatusPages()
        configureSerialization()
        configureMonitoring()
        configureRouting()
//        configureHTTP()
        DBConfig()
    }.start(wait = true)
}
