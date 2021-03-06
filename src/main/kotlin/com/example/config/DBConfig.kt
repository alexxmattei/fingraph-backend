package com.example.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.*

class DBConfig() {
    private val config: HikariConfig = HikariConfig().apply {
        jdbcUrl = "jdbc:mysql://localhost/fingraph_database"
        username = "root"
        password = "1q2w3e"
        maximumPoolSize = 10
    }

    private val dataSource = HikariDataSource(config)

    init {
        Database.connect(dataSource)
    }

}