package com.example.homework_20.data.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework_20.data.dao.UserAccountDao
import com.example.homework_20.data.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserAccountDatabase : RoomDatabase() {
    abstract fun userAccountDao(): UserAccountDao
}