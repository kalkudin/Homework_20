package com.example.homework_20.domain.usecase

import com.example.homework_20.domain.model.UserAccount
import com.example.homework_20.domain.repository.UserAccountRepository
import com.example.homework_20.domain.util.ValidationUtil
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersByEmailUseCase @Inject constructor(
    private val userAccountRepository: UserAccountRepository,
    private val validationUtil: ValidationUtil
) {
    operator fun invoke(email: String): Flow<List<UserAccount>> {
        return userAccountRepository.getUsersByEmail(email = email)
    }
}