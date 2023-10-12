package com.mr_17.mednex.ui.community

import com.mr_17.mednex.ui.community.models.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CommunityApi {
    @GET("posts")
    suspend fun getAllPosts(
    ): Response<List<Post>>

    @GET("posts/{postId}")
    suspend fun getPostById(
        @Path("postId") postId: String
    ): Response<Post>
}