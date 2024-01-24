package com.example.homework_20.domain.usecase

import javax.inject.Inject

data class UserAccountUseCaseCollection @Inject constructor(
    val addUserUseCase: AddNewUserUseCase,
    val deleteUserUseCase: DeleteUserUseCase,
    val updateUserUseCase: UpdateUserUseCase,
    val getAllUsersUseCase: GetAllUsersUseCase
)
