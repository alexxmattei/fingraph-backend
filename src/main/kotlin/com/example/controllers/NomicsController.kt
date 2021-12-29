package com.example.controllers

import com.example.client.nomics.NomicsClient
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*


class NomicsController {
    private val nomicsClient = NomicsClient.create()

    fun addRoutes(route: Route) {
        route.route("/nomics") {
            getCurrencyTest(this)
            getCurrencyById(this)
            getCurrencyMetadataById(this)
        }
    }

    private fun getCurrencyTest(route: Route) {
        route.get("/ping") {
            val pingResponse = nomicsClient.getPing()
            call.respond(HttpStatusCode.OK, pingResponse)
        }
    }

    private fun getCurrencyById(route: Route) {
        route.get("/price/{ids}") {
            call.request.queryParameters["key"]
            val coinId = call.parameters["ids"] ?: ""
            val interval = call.parameters["interval"] ?: "1h"
            val convert = call.parameters["convert"] ?: "USD"
            val status = call.parameters["status"] ?: "active"
            val currencyResponse = nomicsClient.getCurrencyById(coinId, interval, convert, status)

            call.respond(HttpStatusCode.OK, currencyResponse)
        }
    }

    private fun getCurrencyMetadataById(route: Route) {
        route.get("/meta/{ids}") {
            val apiKey = "b41f7cca5feb852dbdaa3f7eca845d9b8c2c7e42"
            val coinId = call.parameters["ids"] ?: "NEXO"
            val currencyMetadataResponse = nomicsClient.getCurrencyMetadataById(apiKey, coinId)

            call.respond(HttpStatusCode.OK, currencyMetadataResponse)
        }
    }
}