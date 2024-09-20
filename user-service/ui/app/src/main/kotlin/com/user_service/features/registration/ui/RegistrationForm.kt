package com.user_service.features.registration.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun RegistrationForm(
        name: String,
        email: String,
        password: String,
        updateField: (String, String)->Unit,
        onRegisterClicked: (String, String, String) -> Unit
) {
  Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
    OutlinedTextField(
            value = name,
            onValueChange = {name -> updateField("name", name) },
            label = { Text("Name") }
    )
    OutlinedTextField(
            value = email,
            onValueChange = { email -> updateField("email", email) },
            label = { Text("Email")}
    )
    OutlinedTextField(
            value = password,
            onValueChange = { password -> updateField("password", password)},
            label = { Text("Password")},
    )
    Button(onClick = { onRegisterClicked(name, email, password) }) { Text("Register") }
  }
}


