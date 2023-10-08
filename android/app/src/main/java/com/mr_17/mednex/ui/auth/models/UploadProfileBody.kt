package com.mr_17.mednex.ui.auth.models

import com.google.gson.annotations.SerializedName

data class UploadProfileBody(
    @SerializedName("email")
    val email: String,
    @SerializedName("fullname")
    val fullName: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("userimage")
    val userImage: String,
)