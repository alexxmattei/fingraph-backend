package com.example.services.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.interfaces.Payload
import com.example.config.JwtConfig
import com.example.models.User
import com.example.models.UserLogin
import com.example.plugins.AuthenticationException
import com.example.services.UserService
import com.example.util.Encryption
import java.lang.Exception
import java.util.*


interface AuthService {
    val verifier: JWTVerifier

    fun validateUser(payload: Payload): User?

    fun generateToken(user: User): String

    fun loginUser(user: UserLogin): String

    fun verifyToken(token: String): Boolean
}

class FingraphAuthService(
    private val userService: UserService
) : AuthService {

    override val verifier: JWTVerifier = JWT
        .require(JwtConfig.algorithm)
        .withSubject("Authentication")
        .withAudience(JwtConfig.audience)
        .withIssuer(JwtConfig.domain)
        .build()

    override fun generateToken(user: User): String = JWT.create()
        .withSubject("Authentication")
        .withAudience(JwtConfig.audience)
        .withIssuer(JwtConfig.domain)
        .withClaim("email", user.email)
        .withClaim("password", user.password)
        .withExpiresAt(getExpiration())
        .sign(JwtConfig.algorithm)

    override fun validateUser(payload: Payload): User? {
        val email: String = payload.getClaim("email").asString()
        val password: String = payload.getClaim("password").asString()
        val user: User = userService.getUserByEmail(email)

        if (password == user.password) {
            return user
        }
        return null
    }

    override fun loginUser(user: UserLogin): String {
        val (email: String, password: String) = user
        val foundUser: User = userService.getUserByEmail(email)
        val jwtToken: String

        // TODO change condition when encrypting password
        //  Encryption.verifyPassword(password, foundUser.password)
        if (password == (foundUser.password)) {
            jwtToken = generateToken(foundUser)
            return jwtToken
        }
        throw AuthenticationException("Invalid password!")
    }

    override fun verifyToken(token: String): Boolean {
        return try {
            verifier.verify(token)
            true
        } catch (ex: Exception) {
            false
        }
    }

    private fun getExpiration() = Date(System.currentTimeMillis() + JwtConfig.validityInMs)
}