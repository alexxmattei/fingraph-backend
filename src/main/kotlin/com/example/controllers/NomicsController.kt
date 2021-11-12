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
            getCurrenciesById(this)
        }
    }

    private fun getCurrenciesById(route: Route) {
        route.get("/price/{ids}") {
            call.request.queryParameters["key"] ?: "b41f7cca5feb852dbdaa3f7eca845d9b8c2c7e42"
            val coinId = call.parameters["ids"] ?: ""
            val interval = call.parameters["interval"] ?: ""
            val convert = call.parameters["convert"] ?: ""
            val status = call.parameters["status"] ?: ""
            val currencyResponse = nomicsClient.getCurrenciesById(coinId, interval, convert, status)

            call.respond(HttpStatusCode.OK, currencyResponse)
        }
    }
}