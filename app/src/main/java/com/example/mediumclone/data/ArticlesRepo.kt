package com.example.mediumclone.data

import io.realworld.api.ConduitClient

object ArticlesRepo {

    val api = ConduitClient.publicApi

        suspend fun getGlobalFeed() = api.getArtciles()

}