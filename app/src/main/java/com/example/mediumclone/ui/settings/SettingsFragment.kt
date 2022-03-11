package com.example.mediumclone.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mediumclone.ui.auth.AuthViewModel
import com.example.mediumclone.databinding.FragmentSettingsBinding

class SettingsFragment: Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val authViewModel by activityViewModels<AuthViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return _binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewModel.user.observe(viewLifecycleOwner) {

            _binding?.apply {

                etBio.setText(it?.bio ?: "")
                etProfileUrl.setText(it?.image ?: "")
                etUsername.setText(it?.username ?: "")
                etEmail.setText(it?.email ?: "")

            }

        }

        _binding?.apply {
            btnUpdate.setOnClickListener {
                authViewModel.update(
                    bio = etBio.text.toString(),
                    username = etUsername.text.toString().takeIf { it.isNotBlank() },
                    image = etProfileUrl.text.toString(),
                    email = etEmail.text.toString().takeIf { it.isNotBlank() },
                    password = etPassword.text.toString().takeIf { it.isNotBlank() }
                )

            }

        }
    }
}