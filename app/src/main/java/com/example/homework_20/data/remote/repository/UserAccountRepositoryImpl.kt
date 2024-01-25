package com.example.homework_20.data.remote.repository

import android.util.Log
import com.example.homework_20.data.remote.dao.UserAccountDao
import com.example.homework_20.data.remote.entities.UserEntity
import com.example.homework_20.data.remote.mapper.toDomain
import com.example.homework_20.data.remote.mapper.toEntity
import com.example.homework_20.domain.model.UserAccount
import com.example.homework_20.domain.repository.UserAccountRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserAccountRepositoryImpl @Inject constructor(private val userAccountDao: UserAccountDao) : UserAccountRepository {
    override suspend fun addNewUser(user: UserAccount) {
        Log.d("Repository", "Adding new user: $user")
        userAccountDao.insert(user.toEntity())
    }

    override suspend fun deleteUser(user: UserAccount) {
        Log.d("Repository", "Deleting user: $user")
        userAccountDao.delete(user.toEntity())
    }

    override suspend fun updateUser(user: UserAccount) {
        Log.d("Repository", "Updating user: $user")
        userAccountDao.update(user.toEntity())
    }

    override fun getUsersByEmail(email: String): Flow<List<UserAccount>> {
        return userAccountDao.getUsersByEmail(email).map { entities ->
            entities.map { it.toDomain() }
        }
    }
}