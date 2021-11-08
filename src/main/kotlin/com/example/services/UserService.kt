package com.example.services

import com.example.models.User

interface UserService {
    fun getUsers() : List<User>;

    fun getUserById(userId: String): User;

    fun getUserByEmail(userEmail: String) : User;

    fun createUser(user: User): User;

    fun modifyUser(userId: String, user: User): User;

    fun modifyPassword(userEmail: String, newPassword: String): User;

    fun removeUser(userId: String): User;
}