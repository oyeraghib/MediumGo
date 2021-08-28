package io.realworld.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.realworld.api.models.entities.User

@JsonClass(generateAdapter = true)
data class UserUpdateRequest(
    @Json(name = "user")
    val user: User?
)