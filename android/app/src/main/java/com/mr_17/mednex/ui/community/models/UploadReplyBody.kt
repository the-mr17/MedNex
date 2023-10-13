package com.mr_17.mednex.ui.community.models


import com.google.gson.annotations.SerializedName

data class UploadReplyBody(
    @SerializedName("author")
    val authorId: String,
    @SerializedName("parentId")
    val parentId: String,
    @SerializedName("text")
    val message: String
)