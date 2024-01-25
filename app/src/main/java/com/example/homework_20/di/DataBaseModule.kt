package com.example.homework_20.di

import android.content.Context
import androidx.room.Room
import com.example.homework_20.data.remote.dao.UserAccountDao
import com.example.homework_20.data.remote.data_base.UserAccountDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): UserAccountDatabase =
        Room.databaseBuilder(
            context, UserAccountDatabase::class.java, "USER_DATABASE"
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideUserAccountDao(database: UserAccountDatabase): UserAccountDao {
        return database.userAccountDao()
    }
}