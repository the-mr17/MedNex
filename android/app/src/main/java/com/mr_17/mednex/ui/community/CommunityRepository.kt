package com.mr_17.mednex.ui.community

import com.mr_17.mednex.data.Resource
import com.mr_17.mednex.ui.community.models.Post

interface CommunityRepository {
    suspend fun getAllPosts(): Resource<List<Post>>
}