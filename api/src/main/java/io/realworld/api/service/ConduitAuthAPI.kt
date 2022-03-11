package io.realworld.api.service

import io.realworld.api.models.requests.UserUpdateRequest
import io.realworld.api.models.responses.ArticleResponse
import io.realworld.api.models.responses.ArticlesResponse
import io.realworld.api.models.responses.ProfileResponse
import io.realworld.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*


/**
 * This is for accessing all requests which requires Authentication.
 */
interface ConduitAuthAPI {

    // for getting current User
    @GET("user")
    suspend fun getCurrentUser(): Response<UserResponse>

    // for updating the User Profile
    @PUT("user")
    suspend fun updateCurrentUser(
        @Body userUpdateRequest: UserUpdateRequest
    ): Response<UserResponse>

    // returns a profile when username is given
    @GET("profile/{username}")
    suspend fun getProfile(
        @Path("username") username: String
    ): Response<ProfileResponse>

    // post request to follow an user
    @POST("profile/{username}/follow")
    suspend fun followProfile(
        @Path("username") username: String
    )

    // for unfollowing a user
    @DELETE("profile/{username}/profile")
    suspend fun unfollowProfile(
        @Path("useranme") username: String
    )

    // Show articles in feed from users you follow
    @GET("articles/feed")
    suspend fun getMyFeedArticle(): Response<ArticlesResponse>

    // Used for creating articles in the feed
    //title, description and body are required parameters
    @POST("articles")
    suspend fun createArticle(
        @Query("title") title: String,
        @Query("description") description: String,
        @Query("body") body: String,
        @Query("tagList") tagList: List<String>,
    ): Response<ArticleResponse>

    //Update articles
    @PUT("articles/{slug}")
    suspend fun updateArticles(
        @Path("slug") slug: String
    ): Response<ArticleResponse>

    // Delete Articles
    @DELETE("articles/{slug}")
    suspend fun deleteArticles()

    // Adding comments to the Article
    @POST("articles/{slug}/comments")
    suspend fun addComment(
        @Path("body") body: String
    )

    // Get all comments from articles
    @GET("articles/{slug}/comments")
    suspend fun readComments(
        @Path("slug") slug: String
    )

    //Delete comment from the article
    @DELETE("articles/{slug}/comments/{id}")
    suspend fun deleteComment(
        @Path("slug") slug: String,
        @Path("id") id: String
    )


    //Favourite an article
    @POST("article/{slug}/favorite")
    suspend fun favoriteArticle(
        @Path("slug") slug: String
    ): Response<ArticlesResponse>

    //Unfavourite an article
    @DELETE("article/{slug}/favorite")
    suspend fun unfavoriteArticle(
        @Path("slug") slug: String
    ): Response<ArticlesResponse>


}

