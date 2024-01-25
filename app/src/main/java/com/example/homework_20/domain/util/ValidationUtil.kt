package com.example.homework_20.domain.util

import javax.inject.Inject

class ValidationUtil @Inject constructor() {
    fun areFieldsNotEmpty(vararg fields: String): Boolean {
        return fields.all { it.isNotEmpty() }
    }

    fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        return email.matches(emailRegex.toRegex())
    }
}