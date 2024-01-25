package com.example.homework_20.presentation.model

sealed class OperationStatus {
    data class Success(val message : String) : OperationStatus()
    data class Failure(val message : String) : OperationStatus()
}
