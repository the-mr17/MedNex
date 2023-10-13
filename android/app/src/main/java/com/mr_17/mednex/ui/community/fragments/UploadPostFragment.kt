package com.mr_17.mednex.ui.community.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mr_17.mednex.MainActivity
import com.mr_17.mednex.R
import com.mr_17.mednex.data.Resource
import com.mr_17.mednex.databinding.FragmentUploadPostBinding
import com.mr_17.mednex.ui.community.CommunityViewModel
import com.mr_17.mednex.ui.community.adapters.PostsRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UploadPostFragment : Fragment(R.layout.fragment_upload_post) {
    private lateinit var binding: FragmentUploadPostBinding
    private val communityViewModel by viewModels<CommunityViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUploadPostBinding.bind(view)

        (activity as MainActivity).setToolbarTitle("Upload Post")

        showLoading(false)

        binding.btnUpload.setOnClickListener {
            communityViewModel.uploadPost(
                "651ce2a0b1edccd4db5dff33",
                binding.etMessage.text.toString()
            )
        }



        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            communityViewModel.uploadPostFlow.collectLatest {
                when(it) {
                    is Resource.Error -> {
                        showLoading(false)
                        showToast(it.message.toString())
                    }
                    is Resource.Success -> {
                        showLoading(false)
                        showToast("Post Uploaded!")
                        findNavController().navigateUp()
                    }
                    is Resource.Loading -> {
                        showLoading(true)
                    }

                    else -> {}
                }
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.apply {
            circularProgressIndicator.isVisible = isLoading
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}