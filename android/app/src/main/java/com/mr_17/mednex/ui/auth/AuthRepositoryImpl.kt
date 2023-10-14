package com.mr_17.mednex.ui.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.mr_17.mednex.data.Resource
import com.mr_17.mednex.ui.auth.models.UploadProfileBody
import com.mr_17.mednex.utils.NetworkUtils.getErrorJson
import kotlinx.coroutines.tasks.await
import retrofit2.HttpException
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val authApi: AuthApi
) : AuthRepository {

    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(email: String, password: String): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message.toString())
        }
    }

    override suspend fun createAccount(
        username: String,
        fullName: String,
        email: String,
        password: String,
        confirmPassword: String,
        category: String
    ): Resource<FirebaseUser> {
        if(password != confirmPassword) {
            return Resource.Error("Passwords mismatch!")
        } else if(password.length < 6) {
            return Resource.Error("Weak Password!")
        }
        return try {
            val response = authApi.uploadMyProfile(
                UploadProfileBody(
                    email,
                    fullName,
                    username,
                    category,
                    ""
                )
            )
            if(response.isSuccessful){
                try {
                    val result =
                        firebaseAuth.createUserWithEmailAndPassword(email, password).await()
                    result.user?.updateProfile(
                        UserProfileChangeRequest.Builder()
                            .setDisplayName(response.body()?.id)
                            .build()
                    )?.await()

                    Resource.Success(result.user!!)
                } catch (e: Exception) {
                    e.printStackTrace()
                    Resource.Error(e.message.toString())
                }
            } else {
                Resource.Error(
                    response
                        .errorBody()
                        ?.getErrorJson()
                        ?.error
                        ?.message
                        .toString()
                )
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error(e.message.toString())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message.toString())
        }
    }

    override suspend fun forgotPassword(email: String): Resource<String> {
        return try {
            firebaseAuth.sendPasswordResetEmail(email).await()
            return Resource.Success("Password reset link has been sent to your email.")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message.toString())
        }
    }

    override suspend fun sendEmailVerification() {
        if(!currentUser?.isEmailVerified!!)
            firebaseAuth.currentUser?.sendEmailVerification()
    }

    override fun logout() {
        firebaseAuth.signOut()
    }
}