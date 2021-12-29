package com.example.controllers

import com.example.client.nomics.NomicsClient
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*


class NomicsController {
    private val nomicsClient = NomicsClient.create()

    fun addRoutes(route: Route) {
        route.route("/nomics") {
            getCurrencyTest(this)
            getCurrencyById(this)
            getCurrencyMetadataById(this)
            getMarketCapHistoryByIdCurrentDate(this)
            getGlobalVolumeHistory(this)
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

    private fun getMarketCapHistoryByIdCurrentDate(route: Route) {
        route.get("/market/{ids}/{start}") {
            call.request.queryParameters["key"]
            val coinId = call.parameters["ids"] ?: ""
            val startDate = call.parameters["start"] ?: LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(ZoneId.of("UTC")))
            val endDate = call.parameters["end"] ?: ""
            val marketCapHistoryByCoinResponse = nomicsClient.getMarketCapHistoryByIdCurrentDate(coinId, startDate, endDate)

            call.respond(HttpStatusCode.OK, marketCapHistoryByCoinResponse)
        }
    }

    private fun getGlobalVolumeHistory(route: Route) {
        route.get("market/volume/{start}") {
            call.request.queryParameters["key"]
            val startDate = call.parameters["start"] ?: LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(ZoneId.of("UTC")))
            val endDate = call.parameters["end"] ?: ""
            val globalVolumeHistoryResponse = nomicsClient.getGlobalVolumeHistory(startDate, endDate)

            call.respond(HttpStatusCode.OK, globalVolumeHistoryResponse)
        }
    }
}