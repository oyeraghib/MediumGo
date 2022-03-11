package com.example.mediumclone.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mediumclone.data.UserRepo
import io.realworld.api.models.entities.User
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> get() = _user


    fun login(email: String, password: String) = viewModelScope.launch {
        UserRepo.login(email, password)?.let {
            _user.postValue(it)
        }

    }

    fun signup(username: String, email: String, password: String ) = viewModelScope.launch {
        UserRepo.signUp(username, email, password)?.let {
            _user.postValue(it)
        }
    }

    fun update(
        bio: String?,
        username: String?,
        image: String?,
        email: String?,
        password: String?
    ) =
        viewModelScope.launch {
        UserRepo.updateUser(bio, username, image, email, password)?.let {
            _user.postValue(it)
        }
    }
}