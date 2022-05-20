package com.example.mediumclone.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mediumclone.databinding.FragmentLoginSignupBinding

class LoginFragment: Fragment() {


    private lateinit var _binding: FragmentLoginSignupBinding
    val authViewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginSignupBinding.inflate(inflater, container, false)

        _binding.etUsername.isVisible = false
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.apply {
            btnSubmit.setOnClickListener {
                authViewModel.login(
                    etEmail.text.toString(),
                    etPassword.text.toString()
                )
            }

        }
    }
}
