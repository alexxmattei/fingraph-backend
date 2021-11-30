package com.example.services

import com.example.models.PasswordRecoveryEntry
import com.example.models.User
import com.example.models.dto.RecoveryRequestResponse
import com.example.repositories.PasswordRecoveryRepository

interface PasswordRecoveryService {
    fun getRecoveryEntries(): List<PasswordRecoveryEntry>

    fun getRecoveryEntryById(id: String): PasswordRecoveryEntry

    fun getRecoveryEntryByEmail(email: String): PasswordRecoveryEntry

    fun createRecoveryEntry(email: String): RecoveryRequestResponse

    fun updatePassword(id: String, newPassword: String): User

    fun deleteRecoveryEntryByEmail(email: String)

    fun deleteAllExpiredEntries()
}
