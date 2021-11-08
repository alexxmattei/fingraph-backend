package com.example

import com.example.config.DBConfig
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureKoin()
        configureRouting()
        configureSerialization()
        configureMonitoring()
        configureHTTP()
        DBConfig()
    }.start(wait = true)
}
