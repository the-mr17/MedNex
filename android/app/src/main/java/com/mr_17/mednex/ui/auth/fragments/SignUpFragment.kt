package com.mr_17.mednex.ui.auth.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.mr_17.mednex.MainActivity
import com.mr_17.mednex.R
import com.mr_17.mednex.data.Resource
import com.mr_17.mednex.databinding.FragmentSignUpBinding
import com.mr_17.mednex.ui.auth.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private lateinit var binding: FragmentSignUpBinding
    private val authViewModel by viewModels<AuthViewModel>()
    private var category: String = "Patient"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)

        (activity as MainActivity).setToolbarTitle("Sign Up")

        binding.apply {
            rgCategory.apply {
                check(R.id.rb_patient)
                setOnCheckedChangeListener { radioGroup, id ->
                when (id) {
                    R.id.rb_patient -> {
                        category = getString(R.string.patient)
                    }
                    R.id.rb_doctor -> {
                        category = getString(R.string.doctor)
                    }
                }
            }
            }

            btnCreateAccount.setOnClickListener {
                authViewModel.createAccount(
                    etUsername.text.toString(),
                    etFullName.text.toString(),
                    etEmailAddress.text.toString(),
                    etPassword.text.toString(),
                    etConfirmPassword.text.toString(),
                    category
                )
            }
        }

        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            authViewModel.createAccountFlow.collectLatest {
                when(it) {
                    is Resource.Error -> {
                        toggleLoading(false)
                        showSnackBar(it.message.toString())
                    }
                    is Resource.Success -> {
                        toggleLoading(false)
                        showSnackBar("success")
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
        binding.btnCreateAccount.visibility = if(!isLoading) View.VISIBLE else View.INVISIBLE
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG)
            .setAction("Okay") {}
            .show()
    }
}