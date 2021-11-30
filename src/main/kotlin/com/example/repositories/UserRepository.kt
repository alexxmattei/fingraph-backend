package com.example.repositories

import com.example.models.User
import com.example.transactions.MariaDbTransactions
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

interface UserRepository {
    fun getUsers(): List<User>;

    fun getUserById(userId: String): User?;

    fun getUserByEmail(userEmail: String): User?;

    fun createUser(user: User): User?;

    fun modifyUser(userId: String, user: User): User?;

    fun modifyPassword(userEmail: String, newPassword: String): User?;

    fun removeUser(userId: String): User?;
}

class MariaDBUserRepository : UserRepository {
    override fun getUsers(): List<User> {
        return transaction {
            MariaDbTransactions.Users.selectAll().map {
                MariaDbTransactions.Users.toUser(it)
            }
        }
    }

    override fun getUserById(userId: String): User? {
        return transaction {
            MariaDbTransactions.Users.select { MariaDbTransactions.Users.id eq Integer.parseInt(userId) }
                .map { MariaDbTransactions.Users.toUser(it) }
        }.firstOrNull()
    }

    override fun getUserByEmail(userEmail: String): User? {
        return transaction {
            MariaDbTransactions.Users.select {
                MariaDbTransactions.Users.email eq userEmail
            }.map { MariaDbTransactions.Users.toUser(it) }
        }.firstOrNull()
    }

    override fun createUser(user: User): User? {
        transaction {
            MariaDbTransactions.Users.insert {
                it[MariaDbTransactions.Users.email] = user.email
                it[MariaDbTransactions.Users.password] = user.password
                it[MariaDbTransactions.Users.fullName] = user.fullName
                it[MariaDbTransactions.Users.callingName] = user.callingName
            }
        }
        return user
    }

    override fun modifyUser(userId: String, user: User): User? {
        transaction {
            MariaDbTransactions.Users.update({
                MariaDbTransactions.Users.id eq Integer.parseInt(userId)
            }) {
                it[MariaDbTransactions.Users.email] = user.email
                it[MariaDbTransactions.Users.password] = user.password
                it[MariaDbTransactions.Users.fullName] = user.fullName
                it[MariaDbTransactions.Users.callingName] = user.callingName
            }
        }
        return user
    }

    override fun modifyPassword(userEmail: String, newPassword: String): User? {
        transaction {
            MariaDbTransactions.Users.update({
                MariaDbTransactions.Users.email eq userEmail
            }) {
                it[MariaDbTransactions.Users.password] = newPassword
            }
        }
        return getUserByEmail(userEmail)
    }

    override fun removeUser(userId: String): User? {
        val userToBeDeleted = getUserById(userId)
        transaction {
            MariaDbTransactions.Users.deleteWhere {
                MariaDbTransactions.Users.id eq Integer.parseInt(userId)
            }
        }
        return userToBeDeleted
    }
}