package com.example.mediumclone.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mediumclone.databinding.FragmentLoginBinding

class LoginFragment: Fragment() {


    private var _binding: FragmentLoginBinding? = null
    private lateinit var authViewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.apply {
            btnLogin.setOnClickListener {
                authViewModel.login(
                    etEmail.text.toString(),
                    etPassword.text.toString()
                )
            }


//            authViewModel.user.observe({ lifecycle }) {
////            updateMenu(it)
//                Toast.makeText(requireContext(), "Logged in with ${it?.email}", Toast.LENGTH_LONG).show()
//            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
