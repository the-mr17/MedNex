package com.mr_17.mednex.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.mr_17.mednex.data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _loginFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Resource<FirebaseUser>?> = _loginFlow

    private val _createAccountFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val createAccountFlow: StateFlow<Resource<FirebaseUser>?> = _createAccountFlow

    private val _forgotPasswordFlow = MutableStateFlow<Resource<String>?>(null)
    val forgotPasswordFlow: StateFlow<Resource<String>?> = _forgotPasswordFlow

    val currentUser: FirebaseUser?
        get() = repository.currentUser

    init {
        if (repository.currentUser != null) {
            _loginFlow.value = Resource.Success(repository.currentUser!!)
        }
    }

    fun loginUser(email: String, password: String) = viewModelScope.launch {
        _loginFlow.value = Resource.Loading()
        val result = repository.login(email, password)
        _loginFlow.value = result
    }

    fun createAccount(
        username: String,
        fullName: String,
        email: String,
        password: String,
        confirmPassword: String,
        category: String
    ) = viewModelScope.launch {
        _createAccountFlow.value = Resource.Loading()
        val result = repository.createAccount(
            username,
            fullName,
            email,
            password,
            confirmPassword,
            category
        )
        _createAccountFlow.value = result
    }

    fun forgotPassword(email: String) = viewModelScope.launch {
        _forgotPasswordFlow.value = Resource.Loading()
        //val result = repository.forgotPassword(email)
        //_forgotPasswordFlow.value = result
    }

    fun sendEmailVerification() = viewModelScope.launch {
        repository.sendEmailVerification()
    }

    fun logout() {
        repository.logout()
        _loginFlow.value = null
        _createAccountFlow.value = null
    }
}
