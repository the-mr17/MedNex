package com.mr_17.mednex.ui.community.models


import com.google.gson.annotations.SerializedName

data class UploadPostBody(
    @SerializedName("author")
    val authorId: String,
    @SerializedName("text")
    val message: String
)