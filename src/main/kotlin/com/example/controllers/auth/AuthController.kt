package com.example.controllers.auth

import com.example.models.User
import com.example.models.UserLogin
import com.example.models.dto.Token
import com.example.models.dto.Valid
import com.example.services.UserService
import com.example.services.auth.AuthService
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

class AuthController(
    private val authService: AuthService,
    private val userService: UserService
) {
    fun addRoutes(route: Route) {
        route.route("/auth") {
            loginRoute(this)
            registerRoute(this)
            verifyTokenRoute(this)
        }
    }

    private fun loginRoute(route: Route) {
        route.post("/login") {
            val user: UserLogin = call.receive()
            val jwtToken: String = authService.loginUser(user)

            call.response.headers.append("Authorization", "Bearer $jwtToken")
            call.respond(HttpStatusCode.OK, Token(jwtToken))
        }
    }

    private fun registerRoute(route: Route) {
        route.post("/register") {
            val user: User = call.receive()
            val createdUser: User = userService.createUser(user)

            call.respond(HttpStatusCode.OK, createdUser)
        }
    }

    private fun verifyTokenRoute(route: Route) {
        route.post("/token") {
            val (token : String) = call.receive<Token>()
            val isTokenValid: Boolean = authService.verifyToken(token)

            call.respond(HttpStatusCode.OK, Valid(isTokenValid))
        }
    }
}