package com.example.transactions

import com.example.models.User
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

class MariaDbTransactions {
    object Users : Table() {
        val id: Column<Int> = integer("userId").autoIncrement().primaryKey();
        val email: Column<String> = varchar("userEmail", 255)
        val password: Column<String> = varchar("password", 255)
        val fullName: Column<String> = varchar("fullName", 255)
        val callingName: Column<String> = varchar("callingName", 255)

        fun toUser(row: ResultRow): User = User(
            id = row[Users.id],
            email = row[Users.email],
            password = row[Users.password],
            fullName = row[Users.fullName],
            callingName = row[Users.callingName]
        )
    }
}