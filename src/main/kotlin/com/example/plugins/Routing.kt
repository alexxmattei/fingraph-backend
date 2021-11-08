package com.example.plugins

import com.example.models.User
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import com.example.repositories.*
import com.example.services.FingraphUserService
import com.example.services.UserService

fun Application.configureRouting() {
    install(Locations) {
    }

    val userRepository = MariaDBUserRepository()
    val userService = FingraphUserService(userRepository)

    routing {
        get("/") {
                call.respondText("Hello World!")
            }
        get("/users") {
            val usersResponse = userService.getUsers()
            call.respond(usersResponse)
        }
        get<MyLocation> {
                call.respondText("Location: name=${it.name}, arg1=${it.arg1}, arg2=${it.arg2}")
            }
            // Register nested routes
            get<Type.Edit> {
                call.respondText("Inside $it")
            }
            get<Type.List> {
                call.respondText("Inside $it")
            }
    }
}
@Location("/location/{name}")
class MyLocation(val name: String, val arg1: Int = 42, val arg2: String = "default")
@Location("/type/{name}") data class Type(val name: String) {
    @Location("/edit")
    data class Edit(val type: Type)

    @Location("/list/{page}")
    data class List(val type: Type, val page: Int)
}

