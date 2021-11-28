package com.example.plugins

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.StatusPages
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import kotlinx.serialization.Serializable

class AuthorizationException(override val message: String) : Exception(message)
class AuthenticationException(override val message: String) : Exception(message)
class IllegalArgumentException(override val message: String) : Exception(message)
class InternalServerError(override val message: String) : Exception(message)
class NotFoundException(override val message: String) : Exception(message)
class NotImplementedException(override val message: String) : Exception(message)

@Serializable
data class ErrorResponse(
    val status: String,
    val message: String
)

fun Application.configureStatusPages() {
    install(StatusPages) {
        exception<AuthorizationException> {
            call.respond(
                HttpStatusCode.Forbidden, ErrorResponse(
                    HttpStatusCode.Forbidden.toString(),
                    it.message
                )
            )
        }

        exception<AuthenticationException> {
            call.respond(
                HttpStatusCode.Unauthorized, ErrorResponse(
                    HttpStatusCode.Unauthorized.toString(),
                    it.message
                )
            )
        }

        exception<IllegalArgumentException> {
            call.respond(
                HttpStatusCode.BadRequest, ErrorResponse(
                    HttpStatusCode.BadRequest.toString(),
                    it.message
                )
            )
        }

        exception<InternalServerError> {
            call.respond(
                HttpStatusCode.InternalServerError, ErrorResponse(
                    HttpStatusCode.InternalServerError.toString(),
                    it.message
                )
            )
        }

        exception<NotFoundException> {
            call.respond(
                HttpStatusCode.NotFound, ErrorResponse(
                    HttpStatusCode.NotFound.toString(),
                    it.message
                )
            )
        }

        exception<NotImplementedException> {
            call.respond(
                HttpStatusCode.NotImplemented, ErrorResponse(
                    HttpStatusCode.NotImplemented.toString(),
                    it.message
                )
            )
        }
    }
}
