package com.user_service.features.registration.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.user_service.entities.user.data.model.repository.UserRepository
import com.user_service.features.registration.domain.RegistrationUseCase
import com.user_service.features.registration.presentation.RegistrationViewModel

@Composable
fun RegistrationScreen(
        viewModel: RegistrationViewModel = remember {
          RegistrationViewModel(RegistrationUseCase(UserRepository()))
        }
) {
  val state by viewModel.uiState

  Column {
    RegistrationForm(
            username = state.name,
            email = state.email,
            password = state.password,
            onRegisterClicked = { username, email, password ->
              viewModel.register(username, email, password)
            }
    )

    // Отображение сообщений об ошибках
    state.error?.let { Text(text = it, color = MaterialTheme.colorScheme.error) }
  }
}

@Preview
@Composable
fun PreviewRegistrationScreen() {
  Surface(color = MaterialTheme.colorScheme.background) { RegistrationScreen() }
}
