package com.example.transactions

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

class MariaDbTransactions {
    object Users : Table() {
        val id: Column<Int> = integer("userId").autoIncrement().primaryKey();
        val email: Column<String> = varchar("userEmail", 255)
        val password: Column<String> = varchar("password", 255)
        val fullName: Column<String> = varchar("fullName", 255)
        val callingName: Column<String> = varchar("callingName", 255)
    }
}