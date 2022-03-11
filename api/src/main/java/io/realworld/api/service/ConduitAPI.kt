package io.realworld.api.service

import io.realworld.api.models.requests.LoginRequest
import io.realworld.api.models.requests.SignupRequest
import io.realworld.api.models.responses.ArticleResponse
import io.realworld.api.models.responses.ArticlesResponse
import io.realworld.api.models.responses.TagsResponse
import io.realworld.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*

/**
 * It is to access all the requests which does not require Authentication.
 */
interface ConduitAPI {

    //for registering new users
    @POST("users")
    suspend fun signupUser(
        @Body userCreds: SignupRequest
    ): Response<UserResponse>

    //for logging in existing user
    @POST("users/login")
    suspend fun loginUser(
        @Body userCreds: LoginRequest
    ): Response<UserResponse>

    //for getting list of articles in global feed
    @GET("articles")
    suspend fun getArticles(
        @Query("author") author: String? = null,
        @Query("favorited") favorited: String? = null,
        @Query("tags") tag: String? = null

    ): Response<ArticlesResponse>


    @GET("articles/{slug}")
    suspend fun getArticlesBySlug(
        @Path("slug") slug: String
    ): Response<ArticleResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagsResponse>


}