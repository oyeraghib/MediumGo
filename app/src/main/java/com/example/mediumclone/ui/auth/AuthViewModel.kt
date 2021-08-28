package com.example.mediumclone.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mediumclone.data.UserRepo
import io.realworld.api.models.entities.User
import io.realworld.api.models.responses.UserResponse
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {

    private val _user = MutableLiveData<User?>()

    var user: LiveData<User?> = _user

    fun login(username: String, password: String) = viewModelScope.launch {
        val user = UserRepo.login(email = "desiarmy828@gmail.com", password)?.let {
            _user.postValue(it.user)
        }

    }
}