package com.example.homework_20.domain.usecase

import com.example.homework_20.domain.model.UserAccount
import com.example.homework_20.domain.repository.UserAccountRepository
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(private val userAccountRepository: UserAccountRepository) {
    suspend operator fun invoke(user: UserAccount) {
        userAccountRepository.deleteUser(user = user)
    }
}