package com.example.controllers

import com.example.models.User
import com.example.services.UserService
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

class UserController(private val userService: UserService) {
    fun addRoutes(route: Route) {
        route.route("/users") {
            getUsers(this)
            getUserById(this)
            getUserByEmail(this)
            createUser(this)
            modifyUser(this)
            removeUser(this)
        }
    }

    private fun getUsers(route: Route) {
        route.get("") {
            val allUsers: List<User> = userService.getUsers()

            call.respond(HttpStatusCode.OK, allUsers)
        }
    }

    private fun getUserById(route: Route) {
        route.get("/id/{userId}") {
            val userId: String = call.parameters["userId"] ?: ""
            val requestedUser: User = userService.getUserById(userId)

            call.respond(HttpStatusCode.OK, requestedUser)
        }
    }

    private fun getUserByEmail(route: Route) {
        route.get("/email/{userEmail}") {
            val userEmail: String = call.parameters["userEmail"] ?: ""
            val foundUser: User = userService.getUserByEmail(userEmail)

            call.respond(HttpStatusCode.OK, foundUser)
        }
    }

    private fun createUser(route: Route) {
        route.post("/create") {
            val newUserInput: User = call.receive()
            val createdUser: User = userService.createUser(newUserInput)

            call.respond(HttpStatusCode.OK, createdUser)
        }
    }

    private fun modifyUser(route: Route) {
        route.put("/id/{userId}") {
            val newUserInput: User = call.receive()
            val userId: String = call.parameters["userId"] ?: ""
            val modifiedUser: User = userService.modifyUser(userId, newUserInput)

            call.respond(HttpStatusCode.OK, modifiedUser)
        }
    }

    private fun removeUser(route: Route) {
        route.delete("id/{userId}") {
            val userId: String = call.parameters["userId"] ?: ""
            val removedUser: User = userService.removeUser(userId)

            call.respond(HttpStatusCode.OK, removedUser)
        }
    }
}