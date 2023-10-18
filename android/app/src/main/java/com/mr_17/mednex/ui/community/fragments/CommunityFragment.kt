package com.mr_17.mednex.ui.community.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mr_17.mednex.MainActivity
import com.mr_17.mednex.R
import com.mr_17.mednex.data.Resource
import com.mr_17.mednex.databinding.FragmentCommunityBinding
import com.mr_17.mednex.ui.community.CommunityViewModel
import com.mr_17.mednex.ui.community.adapters.PostsRecyclerViewAdapter
import com.mr_17.mednex.ui.community.models.Post
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CommunityFragment : Fragment(R.layout.fragment_community), PostsRecyclerViewAdapter.OnClickListener {
    private lateinit var binding: FragmentCommunityBinding
    private val communityViewModel by viewModels<CommunityViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).setToolbarTitle("Community")

        binding = FragmentCommunityBinding.bind(view)

        binding.fabNewPost.setOnClickListener {
            findNavController().navigate(R.id.action_communityFragment_to_uploadPostFragment)
        }

        communityViewModel.getAllPosts()

        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            communityViewModel.allPostsFlow.collectLatest {
                when(it) {
                    is Resource.Error -> {
                        showLoading(false)
                        showToast(it.message.toString())
                    }
                    is Resource.Success -> {
                        showLoading(false)
                        binding.rvPosts.apply {
                            adapter = PostsRecyclerViewAdapter(
                                it.data!!,
                                context,
                                this@CommunityFragment
                            )
                            layoutManager = LinearLayoutManager(context)
                        }
                    }
                    is Resource.Loading -> {
                        showLoading(true)
                    }
                }
            }
        }
    }

    override fun onLikeButtonClick(v: View?, post: Post) {

    }

    override fun onReplyButtonClick(v: View?, post: Post) {
        findNavController().navigate(CommunityFragmentDirections.actionCommunityFragmentToReplyFragment(
            post
        ))
    }

    private fun showLoading(isLoading: Boolean) {
        binding.apply {
            circularProgressIndicator.isVisible = isLoading
            rvPosts.isVisible = !isLoading
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}