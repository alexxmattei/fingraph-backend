package com.example.services

import com.example.models.User
import com.example.repositories.UserRepository
import io.ktor.features.*
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses

interface UserService {
    fun getUsers(): List<User>

    fun getUserById(userId: String): User

    fun getUserByEmail(userEmail: String): User

    fun createUser(user: User): User

    fun modifyUser(userId: String, user: User): User

    fun modifyPassword(userEmail: String, newPassword: String): User

    fun removeUser(userId: String): User
}

class FingraphUserService(private val userRepository: UserRepository) : UserService {
    override fun getUsers(): List<User> {
        val allUsers: List<User> = userRepository.getUsers()

        if (allUsers.isEmpty()) {
            throw NotFoundException("No users were found in our records!")
        }

        return allUsers
    }

    override fun getUserById(userId: String): User =
        userRepository.getUserById(userId) ?: throw NotFoundException("No user could be found with the id '$userId'!")

    override fun getUserByEmail(userEmail: String): User =
        userRepository.getUserByEmail(userEmail)
            ?: throw NotFoundException("No user could be found with the email '$userEmail'!")

    override fun createUser(user: User): User =
        userRepository.createUser(user) ?: throw InternalError("The user could not be created")

    override fun modifyUser(userId: String, user: User): User =
        userRepository.modifyUser(userId, user)
            ?: throw  InternalError("The user with the id '$userId' failed to be updated!")

    override fun modifyPassword(userEmail: String, newPassword: String): User =
        userRepository.modifyPassword(userEmail, newPassword)
            ?: throw InternalError("Could not update password for user '$userEmail'!")

    override fun removeUser(userId: String): User =
        userRepository.removeUser(userId) ?: throw InternalError("Could not remove user with the id '$userId'!")

}

