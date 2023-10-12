package com.mr_17.mednex.ui.community

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

    fun getAllPosts() = viewModelScope.launch {
        val result = repository.getAllPosts()
        _allPostsFlow.value = result
    }
}