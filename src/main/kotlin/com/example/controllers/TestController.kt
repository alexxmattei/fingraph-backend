package com.example.controllers

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

class TestController {
    fun addRoutes(route: Route) {
        route.route("/test") {
            getTest(this)
        }
    }

    private fun getTest(route: Route) {
        route.get("") {
            call.respond(HttpStatusCode.OK,"Hello")
        }
    }
}