package com.mr_17.mednex.ui.auth.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.mr_17.mednex.MainActivity
import com.mr_17.mednex.R
import com.mr_17.mednex.data.Resource
import com.mr_17.mednex.databinding.FragmentLoginBinding
import com.mr_17.mednex.ui.auth.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    private val authViewModel by viewModels<AuthViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        (activity as MainActivity).setToolbarTitle("Login")

        binding.apply {
            btnLogin.setOnClickListener {
                authViewModel.loginUser(etEmailAddress.text.toString(), etPassword.text.toString())
            }
        }

        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            authViewModel.loginFlow.collectLatest {
                when(it) {
                    is Resource.Error -> {
                        toggleLoading(false)
                        showToast(it.message.toString())
                    }
                    is Resource.Success -> {
                        toggleLoading(false)
                        showToast("success")
                        //findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    }
                    is Resource.Loading -> {
                        toggleLoading(true)
                    }
                    else -> {}
                }
            }
        }
    }

    private fun toggleLoading(isLoading: Boolean) {
        binding.loadingBar.isVisible = isLoading
        binding.btnLogin.visibility = if(!isLoading) View.VISIBLE else View.INVISIBLE
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}