package io.realworld.api.models.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.realworld.api.models.entities.Error

@JsonClass(generateAdapter = true)
data class ErrorResponse(
    @Json(name = "errors")
    val error: Error?
)