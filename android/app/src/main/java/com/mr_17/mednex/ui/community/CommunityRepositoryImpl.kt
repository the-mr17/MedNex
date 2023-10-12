package com.mr_17.mednex.ui.community

import com.mr_17.mednex.data.Resource
import com.mr_17.mednex.ui.community.models.Post
import javax.inject.Inject

class CommunityRepositoryImpl @Inject constructor(
    private val communityApi: CommunityApi
): CommunityRepository {
    override suspend fun getAllPosts(): Resource<List<Post>> {
        try {
            val response = communityApi.getAllPosts()
            if(response.isSuccessful) {
                return Resource.Success(response.body()!!)
            }
            return Resource.Error("An error occurred")
        } catch (e: Exception) {
            return Resource.Error(e.message.toString())
        }
    }

}