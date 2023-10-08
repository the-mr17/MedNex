package com.mr_17.mednex.ui.auth

import com.google.firebase.auth.FirebaseUser
import com.mr_17.mednex.data.Resource

interface AuthRepository {
    val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): Resource<FirebaseUser>
    suspend fun createAccount(
        username: String,
        fullName: String,
        email: String,
        password: String,
        confirmPassword: String,
        category: String
    ): Resource<FirebaseUser>
    suspend fun forgotPassword(email: String): Resource<String>
    suspend fun sendEmailVerification()
    fun logout()
}