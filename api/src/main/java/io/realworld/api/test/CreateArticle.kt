package io.realworld.api.test


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateArticle(
    @Json(name = "article")
    val article: Article?
)