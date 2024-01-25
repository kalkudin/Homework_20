package com.example.homework_20.presentation.roomdbfragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_20.domain.util.UserAccountUseCaseCollection
import com.example.homework_20.presentation.event.RoomDbManipulationEvent
import com.example.homework_20.presentation.mapper.toDomain
import com.example.homework_20.presentation.model.OperationStatus
import com.example.homework_20.presentation.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomDBManipulationViewModel @Inject constructor(
    private val userAccountUseCaseCollection: UserAccountUseCaseCollection
): ViewModel() {

    private val _successFlow = MutableSharedFlow<OperationStatus>()
    val successFlow : SharedFlow<OperationStatus> = _successFlow.asSharedFlow()

    fun onEvent(event : RoomDbManipulationEvent) {
        when(event) {
            is RoomDbManipulationEvent.AddUser -> {
                addUser(User(firstName = event.firstName, lastName = event.lastName, email = event.email, age = event.age))
            }
            is RoomDbManipulationEvent.DeleteUser -> {
                deleteUser(User(firstName = event.firstName, lastName = event.lastName, email = event.email, age = event.age))
            }

            is RoomDbManipulationEvent.UpdateUser -> {
                updateUser(User(firstName = event.firstName, lastName = event.lastName, email = event.email, age = event.age))
            }
        }
    }

    private fun addUser(user : User) {
        viewModelScope.launch {
            val existingUsers = userAccountUseCaseCollection.getUsersByEmailUseCase(user.email).first()
            Log.d("ViewModel", "Existing users with email ${user.email}: $existingUsers")
            if (existingUsers.isNotEmpty()) {
                _successFlow.emit(OperationStatus.Failure(message = "User Already Exists"))
            }
            else {
                userAccountUseCaseCollection.addUserUseCase(user = user.toDomain())
                _successFlow.emit(OperationStatus.Success(message = "User Added Successfully"))
            }
        }
    }

    private fun deleteUser(user : User) {
        viewModelScope.launch {
            val existingUsers = userAccountUseCaseCollection.getUsersByEmailUseCase(user.email).first()
            Log.d("ViewModel", "Existing users with email ${user.email}: $existingUsers")
            if (existingUsers.isNotEmpty()) {
                userAccountUseCaseCollection.deleteUserUseCase(user = user.toDomain())
                _successFlow.emit(OperationStatus.Success(message = "User Deleted Successfully"))
            } else {
                _successFlow.emit(OperationStatus.Failure(message = "User Not Found"))
            }
        }
    }

    private fun updateUser(user : User) {
        viewModelScope.launch {
            val existingUsers = userAccountUseCaseCollection.getUsersByEmailUseCase(user.email).first()
            Log.d("ViewModel", "Existing users with email ${user.email}: $existingUsers")
            if (existingUsers.isNotEmpty()) {
                userAccountUseCaseCollection.updateUserUseCase(user = user.toDomain())
                _successFlow.emit(OperationStatus.Success(message = "User Updated Successfully"))
            } else {
                _successFlow.emit(OperationStatus.Failure(message = "User Not Found"))
            }
        }
    }
}
