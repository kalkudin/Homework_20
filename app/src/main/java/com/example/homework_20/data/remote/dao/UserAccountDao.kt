package com.example.homework_20.data.remote.dao

import androidx.room.*
import com.example.homework_20.data.remote.entities.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserAccountDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: UserEntity)

    @Delete
    suspend fun delete(user: UserEntity)

    @Update
    suspend fun update(user: UserEntity)

    @Query("SELECT * FROM users WHERE email = :email")
    fun getUsersByEmail(email: String): Flow<List<UserEntity>>
}