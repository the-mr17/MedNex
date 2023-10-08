package com.mr_17.mednex.ui.auth

import com.mr_17.mednex.ui.auth.models.UploadProfileBody
import com.mr_17.mednex.ui.auth.models.UploadProfileResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthApi {
    @POST("users")
    suspend fun uploadMyProfile(
        @Body body: UploadProfileBody
    ): Response<UploadProfileResponse>

    @GET("users")
    suspend fun getAllUsers(
    ): Response<List<UploadProfileResponse>>

    @GET("users/{username}")
    suspend fun getMyProfile(
        @Path("username") username: String
    ): Response<UploadProfileResponse>
}