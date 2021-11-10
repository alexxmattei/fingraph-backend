package com.example.controllers

import com.example.client.CoinGeckoClient
import com.example.client.CoinGeckoClientImpl
import com.example.models.coingecko.Ping
import io.ktor.application.*
import io.ktor.client.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

class CoinGeckoController {

    private val coinGeckoClient = CoinGeckoClient.create()

    fun addRoutes(route: Route) {
        route.route("/coingecko") {
            getPing(this)
        }
    }

    private fun getPing(route: Route) {
        route.get("/ping") {
            val pingResponse = coinGeckoClient.ping().geckoSays
            call.respond(HttpStatusCode.OK, pingResponse)
        }
    }
}