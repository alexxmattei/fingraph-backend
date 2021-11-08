package com.example.config

import com.example.transactions.MariaDbTransactions
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.*

class DBConfig {
    private val config = HikariConfig().apply {
        jdbcUrl = "jdbc:mysql://localhost/dbname"
        driverClassName = "com.mysql.cj.jdbc.Driver"
        username = "root"
        password = "1q2w3e"
        maximumPoolSize = 10
    }
    private val dataSource = HikariDataSource(config)

    val db = Database.connect(dataSource)

    val initialTransactions = transaction {
        SchemaUtils.create(MariaDbTransactions.Users)

        MariaDbTransactions.Users.insert {
            it[MariaDbTransactions.Users.email] = "johndoe@gmail.com"
            it[MariaDbTransactions.Users.password] = "12345"
            it[MariaDbTransactions.Users.fullName] = "John Doe"
            it[MariaDbTransactions.Users.callingName] = "John"
        }
        MariaDbTransactions.Users.insert {
            it[MariaDbTransactions.Users.email] = "amygerber@gmail.com"
            it[MariaDbTransactions.Users.password] = "12345"
            it[MariaDbTransactions.Users.fullName] = "Amy Gerber"
            it[MariaDbTransactions.Users.callingName] = "Amy"
        }
        MariaDbTransactions.Users.insert {
            it[MariaDbTransactions.Users.email] = "johnsnow@gmail.com"
            it[MariaDbTransactions.Users.password] = "12345"
            it[MariaDbTransactions.Users.fullName] = "John Snow"
            it[MariaDbTransactions.Users.callingName] = "John"
        }

    }
}