package com.example.homework_20.presentation.mapper

import com.example.homework_20.domain.model.UserAccount
import com.example.homework_20.presentation.model.User


fun User.toDomain() : UserAccount {
    return UserAccount(
        firstName = firstName,
        lastName = lastName,
        age = age,
        email = email
    )
}