package com.example.repositories

import com.example.transactions.MariaDbTransactions
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

interface PasswordRecoveryRepository {

//    fun getRecoveryEntries(): List<PasswordRecoveryEntry>
//
//    fun getRecoveryEntryById(id: String): PasswordRecoveryEntry?
//
//    fun getRecoveryEntryByEmail(email: String): PasswordRecoveryEntry?
//
//    fun createRecoveryEntry(recoveryEntry: PasswordRecoveryEntry): InsertOneResult
//
//    fun deleteRecoveryEntryByEmail(email: String): DeleteResult
}

class MariaDBRecoveryRepository : PasswordRecoveryRepository {

//    override fun getRecoveryEntries(): MutableList<PasswordRecoveryEntry> {
//        return transaction {
//            MariaDbTransactions.RecoveryEntries.selectAll().map {
//                MariaDbTransactions.RecoveryEntries.toRecoveries(it)
//            }
//        }
//    }

//    override fun getRecoveryEntryById(id: String): PasswordRecoveryEntry? {
//        return transaction {
//            MariaDbTransactions.RecoveryEntries.select {
//                MariaDbTransactions.RecoveryEntries.id eq Integer.parseInt(
//                    userId
//                )
//            }
//                .map { MariaDbTransactions.Users.toUser(it) }
//        }.firstOrNull()
//    }


//    override fun getRecoveryEntryByEmail(email: String): PasswordRecoveryEntry? {
//
//        return transaction {
//            MariaDbTransactions.RecoveryEntries.select {
//                MariaDbTransactions.RecoveryEntries.id eq Integer.parseInt(
//                    userId
//                )
//            }
//                .map { MariaDbTransactions.Users.toUser(it) }
//        }.firstOrNull()
//    }

//    override fun createRecoveryEntry(recoveryEntry: PasswordRecoveryEntry): InsertOneResult {
//        return transaction {
//            MariaDbTransactions.RecoveryEntries.select {
//                MariaDbTransactions.RecoveryEntries.id eq Integer.parseInt(
//                    userId
//                )
//            }
//                .map { MariaDbTransactions.Users.toUser(it) }
//        }.firstOrNull()
//    }


//    override fun deleteRecoveryEntryByEmail(email: String): DeleteResult {
//        return transaction {
//            MariaDbTransactions.RecoveryEntries.select {
//                MariaDbTransactions.RecoveryEntries.id eq Integer.parseInt(
//                    userId
//                )
//            }
//                .map { MariaDbTransactions.Users.toUser(it) }
//        }.firstOrNull()
//    }
}
