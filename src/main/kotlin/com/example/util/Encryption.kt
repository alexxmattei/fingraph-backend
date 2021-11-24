package com.example.util

import de.mkammerer.argon2.Argon2Factory

object Encryption {
    private val argon2 = Argon2Factory.create(
        Argon2Factory.Argon2Types.ARGON2d,
        16,
        16
    )

    fun encryptPassword(password: String): String = argon2.hash(
        16,
        65536,
        1,
        password.toCharArray()
    )

    fun verifyEncryptedPassword(password: String, encryptedPassword: String): Boolean =
        argon2.verify(encryptedPassword, password.toCharArray())
}
