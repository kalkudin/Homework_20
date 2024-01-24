package com.example.homework_20.presentation.event

sealed class RoomDbManipulationEvent {
    data class UpdateUser(val firstName : String, val lastName : String, val email : String, val age : String) : RoomDbManipulationEvent()
    data class DeleteUser(val firstName : String, val lastName : String, val email : String, val age : String) : RoomDbManipulationEvent()
    data class AddUser(val firstName : String, val lastName : String, val email : String, val age : String) : RoomDbManipulationEvent()
}
