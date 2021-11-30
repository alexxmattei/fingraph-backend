package com.example.repositories

import com.example.models.PasswordRecoveryEntry
import com.example.transactions.MariaDbTransactions
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

interface PasswordRecoveryRepository {
    fun getRecoveryEntries(): List<PasswordRecoveryEntry>

    fun getRecoveryEntryById(id: String): PasswordRecoveryEntry?

    fun getRecoveryEntryByEmail(email: String): PasswordRecoveryEntry?

    fun createRecoveryEntry(recoveryEntry: PasswordRecoveryEntry): PasswordRecoveryEntry?

    fun deleteRecoveryEntryByEmail(email: String): PasswordRecoveryEntry?
}

class MariaDBPasswordRecoveryRepository : PasswordRecoveryRepository {

    override fun getRecoveryEntries(): List<PasswordRecoveryEntry> {
        return transaction {
            MariaDbTransactions.RecoveryEntries.selectAll().map {
                MariaDbTransactions.RecoveryEntries.toRecoveries(it)
            }
        }
    }

    override fun getRecoveryEntryById(id: String): PasswordRecoveryEntry? {
        return transaction {
            MariaDbTransactions.RecoveryEntries.select {
                MariaDbTransactions.RecoveryEntries.id eq id
            }.map { MariaDbTransactions.RecoveryEntries.toRecoveries(it) }
        }.firstOrNull()
    }


    override fun getRecoveryEntryByEmail(email: String): PasswordRecoveryEntry? {
        return transaction {
            MariaDbTransactions.RecoveryEntries.select {
                MariaDbTransactions.RecoveryEntries.id eq email
            }.map { MariaDbTransactions.RecoveryEntries.toRecoveries(it) }
        }.firstOrNull()
    }

    override fun createRecoveryEntry(recoveryEntry: PasswordRecoveryEntry): PasswordRecoveryEntry? {
        transaction {
            MariaDbTransactions.RecoveryEntries.insert {
                it[MariaDbTransactions.RecoveryEntries.id] = recoveryEntry.id
                it[MariaDbTransactions.RecoveryEntries.email] = recoveryEntry.email
                it[MariaDbTransactions.RecoveryEntries.expirationDate] = recoveryEntry.expirationDate
            }
        }
        return recoveryEntry
    }


    override fun deleteRecoveryEntryByEmail(email: String): PasswordRecoveryEntry? {
        val recoveryEntryToBeDeleted = getRecoveryEntryByEmail(email)
        transaction {
            MariaDbTransactions.RecoveryEntries.deleteWhere {
                MariaDbTransactions.RecoveryEntries.email eq email
            }
        }
        return recoveryEntryToBeDeleted
    }
}
