package com.example.homework_20.di

import com.example.homework_20.data.remote.dao.UserAccountDao
import com.example.homework_20.data.remote.repository.UserAccountRepositoryImpl
import com.example.homework_20.domain.repository.UserAccountRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideUserAccountRepository(userAccountDao: UserAccountDao): UserAccountRepository {
        return UserAccountRepositoryImpl(userAccountDao)
    }
}