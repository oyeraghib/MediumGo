package com.example.mediumclone.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.mediumclone.AuthViewModel
import com.example.mediumclone.databinding.FragmentLoginSignupBinding

class SignupFragment: Fragment() {

    private var _binding: FragmentLoginSignupBinding? = null
    val authViewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginSignupBinding.inflate(inflater, container, false)
        _binding?.etUsername?.isVisible = true

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        _binding?.apply {
            btnSubmit.setOnClickListener{

                authViewModel.signup(
                    etUsername.text.toString(),
                    etEmail.text.toString(),
                    etPassword.text.toString()
                    )
            }
        }

        authViewModel.user.observe({lifecycle}) {
            Toast.makeText(requireContext(), "Signed In as ${it?.username}", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}