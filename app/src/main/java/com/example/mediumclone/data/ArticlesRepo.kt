package com.example.mediumclone.data

import io.realworld.api.ConduitClient

object ArticlesRepo {

    val api = ConduitClient.publicApi
    val authAPI = ConduitClient.authApi

        suspend fun getGlobalFeed() = api.getArtciles()

        suspend fun getMyFeed() = authAPI.getFeedArticles()

}