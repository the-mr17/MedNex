package com.mr_17.mednex.ui.auth.models


import com.google.gson.annotations.SerializedName

data class UploadProfileResponse(
    @SerializedName("category")
    val category: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("fullname")
    val fullName: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("userimage")
    val userImage: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("__v")
    val v: Int
)