package com.example.exhibitionstall.ui.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

enum class AuthState {
    REGISTER, LOGIN, HOME
}

data class User(
    val name: String,
    val email: String
)

class AuthViewModel : ViewModel() {

    private val _authState = MutableStateFlow(AuthState.REGISTER)
    val authState: StateFlow<AuthState> = _authState

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    fun register(
        name: String,
        email: String,
        password: String,
        onError: (String) -> Unit
    ) {
        if (name.isBlank() || email.isBlank() || password.length < 6) {
            onError("Fill all fields (password ≥ 6 chars)")
            return
        }

        // Mock registration logic
        _user.value = User(name, email)
        _authState.value = AuthState.LOGIN
    }

    fun login(
        email: String,
        password: String,
        onError: (String) -> Unit
    ) {
        if (_user.value?.email == email) {
            _authState.value = AuthState.HOME
        } else {
            onError("User not found or invalid credentials")
        }
    }

    fun logout() {
        _authState.value = AuthState.LOGIN
    }
}