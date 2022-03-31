package io.realworld.api

import io.realworld.api.models.entities.User
import io.realworld.api.models.requests.SignupRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Assert.assertNotNull
import kotlin.random.Random


class ConduitClientTest {


    //Test for Articles
    @Test
    fun `get Articles`() {

        runBlocking {

            val articles = ConduitClient.publicApi.getArticles()
            assertNotNull(articles.body()?.articles)
        }

    }

    //Test for Articles by author (global feed)
    @Test
    fun `get Articles by author`() {

        runBlocking {

            val articles = ConduitClient.publicApi.getArticles(author = "cy271839439")
            assertNotNull(articles.body()?.articles)

        }
    }


    //Test for Articles by tags
    @Test
    fun `get Articles by tags`() {

        runBlocking {

            val articles = ConduitClient.publicApi.getArticles(tag = "butts")
            assertNotNull(articles.body()?.articles)

        }
    }
}

