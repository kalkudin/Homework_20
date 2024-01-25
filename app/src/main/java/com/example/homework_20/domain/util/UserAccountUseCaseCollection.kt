package com.example.homework_20.domain.util

import com.example.homework_20.domain.usecase.AddNewUserUseCase
import com.example.homework_20.domain.usecase.DeleteUserUseCase
import com.example.homework_20.domain.usecase.GetUsersByEmailUseCase
import com.example.homework_20.domain.usecase.UpdateUserUseCase
import javax.inject.Inject

data class UserAccountUseCaseCollection @Inject constructor(
    val addUserUseCase: AddNewUserUseCase,
    val deleteUserUseCase: DeleteUserUseCase,
    val updateUserUseCase: UpdateUserUseCase,
    val getUsersByEmailUseCase: GetUsersByEmailUseCase
)
