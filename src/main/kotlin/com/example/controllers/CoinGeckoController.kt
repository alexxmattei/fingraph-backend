package com.example.controllers

import com.example.client.coingecko.CoinGeckoClient
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

class CoinGeckoController {

    private val coinGeckoClient = CoinGeckoClient.create()

    fun addRoutes(route: Route) {
        route.route("/coingecko") {
            getPing(this)
            getPriceByCoin(this)
            getPriceByCoinUserFiat(this)
        }
    }

    private fun getPing(route: Route) {
        route.get("/ping") {
            val pingResponse = coinGeckoClient.ping().geckoSays
            call.respond(HttpStatusCode.OK, pingResponse)
        }
    }

    // default in USD
    private fun getPriceByCoin(route: Route) {
        route.get("/price/{coinId}") {
            val coinId = call.parameters["coinId"] ?: "BTC"
            val priceByCoin = coinGeckoClient.getPrice(coinId, "USD")
            call.respond(HttpStatusCode.OK, priceByCoin)
        }
    }

    // converts to user default currency
    // defaults to USD
    private fun getPriceByCoinUserFiat(route: Route) {
        route.get("/price/{coinId}/{fiatId}") {
            val coinId = call.parameters["coinId"] ?: ""
            val fiatId = call.parameters["fiatId"] ?: "USD"
            val priceByCoin = coinGeckoClient.getPrice(coinId, fiatId)
            call.respond(HttpStatusCode.OK, priceByCoin)
        }
    }
}