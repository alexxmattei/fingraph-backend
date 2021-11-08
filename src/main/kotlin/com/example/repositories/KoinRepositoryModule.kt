package com.example.repositories

import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> {
        MariaDBUserRepository()
    }
}