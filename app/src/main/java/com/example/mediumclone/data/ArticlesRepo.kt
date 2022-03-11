package com.example.mediumclone.data

import io.realworld.api.ConduitClient

object ArticlesRepo {

    val api = ConduitClient.publicApi
    val authAPI = ConduitClient.authApi

        suspend fun getGlobalFeed() = api.getArticles().body()?.articles
        suspend fun getMyFeed() = authAPI.getMyFededArticles().body()?.articles
}


