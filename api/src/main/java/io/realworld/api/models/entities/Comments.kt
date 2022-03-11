package io.realworld.api.models.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.realworld.api.models.entities.Profile

@JsonClass(generateAdapter = true)
data class Comments(
    @Json(name = "author")
    val author: Profile?,
    @Json(name = "body")
    val body: String?,
    @Json(name = "createdAt")
    val createdAt: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "updatedAt")
    val updatedAt: String?
)