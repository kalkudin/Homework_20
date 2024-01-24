package com.example.homework_20.domain.usecase

import com.example.homework_20.domain.model.UserAccount
import com.example.homework_20.domain.repository.UserAccountRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val userAccountRepository: UserAccountRepository
) {
    operator fun invoke(): Flow<List<UserAccount>> {
        return userAccountRepository.getAllUsers()
    }
}