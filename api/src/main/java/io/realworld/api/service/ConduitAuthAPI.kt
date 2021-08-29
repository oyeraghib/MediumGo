package io.realworld.api.service

import io.realworld.api.models.entities.User
import io.realworld.api.models.requests.UserUpdateRequest
import io.realworld.api.models.responses.ArticleResponse
import io.realworld.api.models.responses.ArticlesResponse
import io.realworld.api.models.responses.ProfileResponse
import io.realworld.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*
import java.lang.invoke.StringConcatFactory

interface ConduitAuthAPI {

    @GET("user")
    suspend fun getCurrentUser(): Response<UserResponse>

    @POST("user")
    suspend fun updateCurrentUser(
        @Body userUpdateRequest : UserUpdateRequest
    ): Response<UserResponse>

    @GET("profile/{username}")
    suspend fun getProfile(
        @Path ("username")username: String
    ): Response<ProfileResponse>

    @POST("profile/{username}/follow")
    suspend fun followProfile(
        @Path("username")username: String
    )

    @DELETE("profile/{username}/profile")
    suspend fun unfollowProfile(
        @Path("useranme")username: String
    )

    @GET("articles/feed")
    suspend fun getFeedArticles(): Response<ArticlesResponse>

    @POST("article/{slug}/favorite")
    suspend fun favoriteArticle(
        @Path("slug")slug: String
    ): Response<ArticlesResponse>

    @DELETE("article/{slug}/favorite")
    suspend fun unfavoriteArticle(
        @Path("slug")slug: String
    ): Response<ArticlesResponse>




    }

