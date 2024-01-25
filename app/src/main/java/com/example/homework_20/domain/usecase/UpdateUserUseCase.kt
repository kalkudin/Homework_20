package com.example.homework_20.domain.usecase

import com.example.homework_20.domain.model.UserAccount
import com.example.homework_20.domain.repository.UserAccountRepository
import com.example.homework_20.domain.util.ValidationUtil
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(
    private val userAccountRepository: UserAccountRepository,
    private val validationUtil: ValidationUtil
) {
    suspend operator fun invoke(user: UserAccount) {
        userAccountRepository.updateUser(user = user)
    }
}