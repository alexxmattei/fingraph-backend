package com.example.repositories

import com.example.models.User

interface UserRepository {
    fun getUsers(): List<User>;

    fun getUserById(userId: String): User?;

    fun getUserByEmail(userEmail: String): User?;

    fun createUser(user: User): User?;

    fun modifyUser(userId: String, user: User): User?;

    fun modifyPassword(userEmail: String, newPassword: String): User?;

    fun removeUser(userId: String): User?;
}

class MariaDBUserRepository: UserRepository {
    override fun getUsers(): List<User> {
        TODO("Not yet implemented")
    }

    override fun getUserById(userId: String): User? {
        TODO("Not yet implemented")
    }

    override fun getUserByEmail(userEmail: String): User? {
        TODO("Not yet implemented")
    }

    override fun createUser(user: User): User? {
        TODO("Not yet implemented")
    }

    override fun modifyUser(userId: String, user: User): User? {
        TODO("Not yet implemented")
    }

    override fun modifyPassword(userEmail: String, newPassword: String): User? {
        TODO("Not yet implemented")
    }

    override fun removeUser(userId: String): User? {
        TODO("Not yet implemented")
    }
}