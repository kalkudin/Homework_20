package com.example.homework_20.data.remote.mapper

import com.example.homework_20.data.remote.entities.UserEntity
import com.example.homework_20.domain.model.UserAccount

fun UserEntity.toDomain(): UserAccount {
    return UserAccount(
        firstName = firstName,
        lastName = lastName,
        email = email,
        age = age
    )
}