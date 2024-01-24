package com.example.homework_20.data.mapper

import com.example.homework_20.data.entities.UserEntity
import com.example.homework_20.domain.model.UserAccount

fun UserAccount.toEntity(): UserEntity {
    return UserEntity(
        firstName = firstName,
        lastName = lastName,
        email = email,
        age = age
    )
}