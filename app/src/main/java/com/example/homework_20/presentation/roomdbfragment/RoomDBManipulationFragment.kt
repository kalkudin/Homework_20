package com.example.homework_20.presentation.roomdbfragment

import androidx.fragment.app.viewModels
import com.example.homework_20.databinding.FragmentRoomDbManipulationLayoutBinding
import com.example.homework_20.presentation.base.BaseFragment
import com.example.homework_20.presentation.event.RoomDbManipulationEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomDBManipulationFragment :
    BaseFragment<FragmentRoomDbManipulationLayoutBinding>(FragmentRoomDbManipulationLayoutBinding::inflate) {

    private val viewModel: RoomDBManipulationViewModel by viewModels()

    override fun bind() {

    }

    override fun bindViewActionListeners() {
        bindAddBtn()
        bindUpdateBtn()
        bindDeleteBtn()
    }

    override fun bindObservers() {

    }

    private fun bindAddBtn() {
        with(binding) {
            btnAddUser.setOnClickListener {
                viewModel.onEvent(
                    RoomDbManipulationEvent.AddUser(
                        firstName = etFirstName.text.toString(),
                        lastName = etLastName.text.toString(),
                        email = etEmail.text.toString(),
                        age = etAge.text.toString()
                    )
                )
            }
        }
    }

    private fun bindUpdateBtn() {
        with(binding) {
            btnDeleteUser.setOnClickListener {
                viewModel.onEvent(
                    RoomDbManipulationEvent.DeleteUser(
                        firstName = etFirstName.text.toString(),
                        lastName = etLastName.text.toString(),
                        email = etEmail.text.toString(),
                        age = etAge.text.toString()
                    )
                )
            }
        }
    }

    private fun bindDeleteBtn() {
        with(binding) {
            btnUpdateUser.setOnClickListener {
                viewModel.onEvent(
                    RoomDbManipulationEvent.UpdateUser(
                        firstName = etFirstName.text.toString(),
                        lastName = etLastName.text.toString(),
                        email = etEmail.text.toString(),
                        age = etAge.text.toString()
                    )
                )
            }
        }
    }
}