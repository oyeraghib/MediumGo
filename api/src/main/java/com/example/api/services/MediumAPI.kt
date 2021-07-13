package com.example.api.services

import com.example.api.models.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET

interface MediumAPI {

    @GET("articles")
    fun getArticles() : Call<ArticleResponse>

}