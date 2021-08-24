package io.realworld.api.service

import io.realworld.api.models.ArticlesResponse
import io.realworld.api.models.TagsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ConduitAPI {

    @GET("articles")
    fun getArtciles(): Call<ArticlesResponse>

    @GET("tags")
    fun getTags(): Call<TagsResponse>


}