package com.example.homework_20.presentation.roomdbfragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_20.domain.usecase.UserAccountUseCaseCollection
import com.example.homework_20.presentation.event.RoomDbManipulationEvent
import com.example.homework_20.presentation.mapper.toDomain
import com.example.homework_20.presentation.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomDBManipulationViewModel @Inject constructor(
    private val userAccountUseCaseCollection: UserAccountUseCaseCollection
): ViewModel() {

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
            userAccountUseCaseCollection.addUserUseCase(user = user.toDomain())

//            viewModelScope.launch {
//                userAccountUseCaseCollection.getAllUsersUseCase().collect { users ->
//                    Log.d("ViewModel", "Collected users: $users")
//                }
//            }
        }
    }

    private fun deleteUser(user : User) {
        viewModelScope.launch {
            userAccountUseCaseCollection.deleteUserUseCase(user = user.toDomain())
        }
    }

    private fun updateUser(user : User) {
        viewModelScope.launch {
            userAccountUseCaseCollection.updateUserUseCase(user = user.toDomain())
        }
    }
}
