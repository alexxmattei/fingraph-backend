package com.example.plugins

import com.example.controllers.controllerModule
import com.example.repositories.repositoryModule
import com.example.services.serviceModule
import io.ktor.application.Application
import io.ktor.application.install
import org.koin.ktor.ext.Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(controllerModule + serviceModule + repositoryModule)
    }
}