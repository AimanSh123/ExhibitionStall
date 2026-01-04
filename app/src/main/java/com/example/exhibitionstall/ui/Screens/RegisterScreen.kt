package com.example.exhibitionstall.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.exhibitionstall.ui.auth.AuthState
import com.example.exhibitionstall.ui.auth.AuthViewModel

@Composable
fun RegisterScreen(
    authViewModel: AuthViewModel,
    navToLogin: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }

    // Observe authState
    val authState by authViewModel.authState.collectAsState()

    // Navigate to login automatically if registration changes state to LOGIN
    LaunchedEffect(authState) {
        if (authState == AuthState.LOGIN) {
            navToLogin()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text("Register", style = MaterialTheme.typography.headlineMedium)

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            error?.let { Text(it, color = MaterialTheme.colorScheme.error) }

            Button(
                onClick = {
                    // Only provide onError, handle navigation via authState observer
                    authViewModel.register(
                        name = name,
                        email = email,
                        password = password,
                        onError = { errMsg ->
                            error = errMsg
                        }
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Create Account")
            }

            TextButton(onClick = navToLogin) {
                Text("Already have an account? Login")
            }
        }
    }
}
