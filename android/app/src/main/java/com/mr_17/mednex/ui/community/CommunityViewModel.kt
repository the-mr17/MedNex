package com.mr_17.mednex.ui.community

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mr_17.mednex.data.Resource
import com.mr_17.mednex.ui.community.models.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(
    private val repository: CommunityRepository
): ViewModel() {
    private val _allPostsFlow = MutableStateFlow<Resource<List<Post>>>(Resource.Loading())
    val allPostsFlow: StateFlow<Resource<List<Post>>> = _allPostsFlow

    private val _allChildrenPostsFlow = MutableStateFlow<Resource<List<Post>>>(Resource.Loading())
    val allChildrenPostsFlow: StateFlow<Resource<List<Post>>> = _allChildrenPostsFlow

    private val _uploadPostFlow = MutableStateFlow<Resource<Post>?>(null)
    val uploadPostFlow: StateFlow<Resource<Post>?> = _uploadPostFlow

    private val _uploadReplyFlow = MutableStateFlow<Resource<Post>?>(null)
    val uploadReplyFlow: StateFlow<Resource<Post>?> = _uploadReplyFlow

    fun getAllPosts() = viewModelScope.launch {
        val result = repository.getAllPosts()
        _allPostsFlow.value = result
    }

    fun getAllChildrenPosts(childrenIdList: List<String>) = viewModelScope.launch {
        val result = repository.getAllChildrenPosts(childrenIdList)
        _allChildrenPostsFlow.value = result
    }

    fun uploadPost(authorId: String, message: String) = viewModelScope.launch {
        val result = repository.uploadPost(authorId, message)
        _uploadPostFlow.value = result
    }

    fun uploadReply(authorId: String, parentId: String, message: String) = viewModelScope.launch {
        val result = repository.uploadReply(authorId, parentId, message)
        _uploadReplyFlow.value = result
    }
}