package com.mr_17.mednex.ui.community

import com.mr_17.mednex.data.Resource
import com.mr_17.mednex.ui.community.models.Post

interface CommunityRepository {
    suspend fun getAllPosts(): Resource<List<Post>>
    suspend fun getAllChildrenPosts(childrenIdList: List<String>): Resource<List<Post>>
    suspend fun uploadPost(authorId: String, message: String): Resource<Post>
    suspend fun uploadReply(authorId: String, parentId: String, message: String): Resource<Post>
}