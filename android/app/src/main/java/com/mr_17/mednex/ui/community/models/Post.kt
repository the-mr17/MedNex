package com.mr_17.mednex.ui.community.models

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("author")
    val authorId: String,
    @SerializedName("children")
    val childrenIdList: List<String>,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("parentId")
    val parentId: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("__v")
    val v: Int
)