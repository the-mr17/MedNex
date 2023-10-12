package com.mr_17.mednex.ui.community.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.mr_17.mednex.R
import com.mr_17.mednex.databinding.FragmentCommunityBinding

class CommunityFragment : Fragment(R.layout.fragment_community) {
    private lateinit var binding: FragmentCommunityBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCommunityBinding.bind(view)
    }
}