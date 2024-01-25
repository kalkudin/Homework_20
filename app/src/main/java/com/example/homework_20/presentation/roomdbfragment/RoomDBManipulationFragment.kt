package com.example.homework_20.presentation.roomdbfragment

import android.graphics.Color
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.homework_20.databinding.FragmentRoomDbManipulationLayoutBinding
import com.example.homework_20.presentation.base.BaseFragment
import com.example.homework_20.presentation.event.RoomDbManipulationEvent
import com.example.homework_20.presentation.model.OperationStatus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RoomDBManipulationFragment :
    BaseFragment<FragmentRoomDbManipulationLayoutBinding>(FragmentRoomDbManipulationLayoutBinding::inflate) {

    private val viewModel: RoomDBManipulationViewModel by viewModels()

    override fun bindViewActionListeners() {
        bindAddBtn()
        bindUpdateBtn()
        bindDeleteBtn()
    }

    override fun bindObservers() {
        bindSuccessFlow()
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

    private fun bindSuccessFlow() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.successFlow.collect { status ->
                    when(status) {
                        is OperationStatus.Success -> displaySuccessMessage(message = status.message)
                        is OperationStatus.Failure -> displayErrorMessage(message = status.message)
                    }
                }
            }
        }
    }

    private fun displayErrorMessage(message : String) {
        with(binding) {
            tvMessage.text = message
            tvMessage.setTextColor(Color.RED)
        }
    }

    private fun displaySuccessMessage(message : String) {
        with(binding) {
            tvMessage.text = message
            tvMessage.setTextColor(Color.GREEN)
        }
    }
}