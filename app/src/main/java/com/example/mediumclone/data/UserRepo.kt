package com.example.mediumclone.data

import io.realworld.api.ConduitClient
import io.realworld.api.models.entities.LoginData
import io.realworld.api.models.entities.SignupData
import io.realworld.api.models.entities.UserUpdate
import io.realworld.api.models.entities.User
import io.realworld.api.models.requests.LoginRequest
import io.realworld.api.models.requests.SignupRequest
import io.realworld.api.models.requests.UserUpdateRequest

object UserRepo {

    val api = ConduitClient.publicApi

    val authAPI = ConduitClient.authApi

    suspend fun login(email: String, password: String): User? {

        val response = api.loginUser(LoginRequest(LoginData(email, password)))

        ConduitClient.authToken = response.body()?.user?.token

            return response.body()?.user

    }

    suspend fun signUp(username: String, email: String, password: String): User? {

        val response = api.signupUser(SignupRequest(SignupData(username, email, password)))

        ConduitClient.authToken = response.body()?.user?.token

        return response.body()?.user
    }

    suspend fun updateUser(
        bio: String?,
        email: String?,
        image: String?,
        username: String?,
        password: String?)
    : User? {

        val response = authAPI.updateCurrentUser(UserUpdateRequest(UserUpdate(bio, email, image, username, password)))

        return response.body()?.user
    }

}
