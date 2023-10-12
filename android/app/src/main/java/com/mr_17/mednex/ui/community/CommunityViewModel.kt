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

    fun getAllPosts() = viewModelScope.launch {
        val result = repository.getAllPosts()
        _allPostsFlow.value = result
    }

    fun getAllChildrenPosts(childrenIdList: List<String>) = viewModelScope.launch {
        val result = repository.getAllChildrenPosts(childrenIdList)
        Log.d("result", result.data.toString())
        _allChildrenPostsFlow.value = result
    }
}