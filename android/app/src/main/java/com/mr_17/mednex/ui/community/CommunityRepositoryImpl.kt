package com.mr_17.mednex.ui.community

import com.mr_17.mednex.data.Resource
import com.mr_17.mednex.ui.auth.AuthApi
import com.mr_17.mednex.ui.community.models.Post
import com.mr_17.mednex.ui.community.models.UploadPostBody
import com.mr_17.mednex.ui.community.models.UploadReplyBody
import javax.inject.Inject

class CommunityRepositoryImpl @Inject constructor(
    private val communityApi: CommunityApi,
    private val authApi: AuthApi
): CommunityRepository {
    override suspend fun getAllPosts(): Resource<List<Post>> {
        try {
            val response = communityApi.getAllPosts()
            val result = ArrayList<Post>()
            if(response.isSuccessful) {
                response.body()?.forEach {
                    // only replies will have a parentId
                    if(it.parentId == null) {
                        // getting username by using authorId of each post
                        val userResponse
                            = authApi.getUserByUserId(it.authorId)
                        if(userResponse.isSuccessful) {
                            it.username = userResponse.body()?.username.toString()
                            result.add(it)
                        }
                    }
                }
                return Resource.Success(result)
            }
            return Resource.Error("An error occurred")
        } catch (e: Exception) {
            return Resource.Error(e.message.toString())
        }
    }

    override suspend fun getAllChildrenPosts(childrenIdList: List<String>): Resource<List<Post>> {
        return try {
            val result = ArrayList<Post>()
            childrenIdList.forEach {
                val response = communityApi.getPostById(it)
                if(response.isSuccessful) {
                    // getting username by using authorId of each post
                    val userResponse
                            = authApi.getUserByUserId(response.body()?.authorId!!)
                    if(userResponse.isSuccessful) {
                        response.body()?.username = userResponse.body()?.username.toString()
                        result.add(response.body()!!)
                    }
                }
            }
            Resource.Success(result)
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }

    override suspend fun uploadPost(authorId: String, message: String): Resource<Post> {
        try {
            val response = communityApi.uploadPost(
                UploadPostBody(
                    authorId,
                    message
                )
            )
            if(response.isSuccessful) {
                return Resource.Success(response.body()!!)
            }
            return Resource.Error("An error occurred")
        } catch (e: Exception) {
            return Resource.Error(e.message.toString())
        }
    }

    override suspend fun uploadReply(
        authorId: String,
        parentId: String,
        message: String
    ): Resource<Post> {
        try {
            val response = communityApi.uploadReply(
                UploadReplyBody(
                    authorId,
                    parentId,
                    message
                )
            )
            if(response.isSuccessful) {
                return Resource.Success(response.body()!!)
            }
            return Resource.Error("An error occurred")
        } catch (e: Exception) {
            return Resource.Error(e.message.toString())
        }
    }

}