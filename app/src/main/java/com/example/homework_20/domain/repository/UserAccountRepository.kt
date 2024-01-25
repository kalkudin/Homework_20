package com.example.homework_20.domain.repository

import com.example.homework_20.domain.model.UserAccount
import kotlinx.coroutines.flow.Flow

interface UserAccountRepository {
    suspend fun addNewUser(user : UserAccount)
    suspend fun deleteUser(user : UserAccount)
    suspend fun updateUser(user : UserAccount)
    fun getUsersByEmail(email: String): Flow<List<UserAccount>>
}