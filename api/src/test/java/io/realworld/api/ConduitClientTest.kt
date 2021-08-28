package io.realworld.api

import io.realworld.api.models.requests.SignupRequest
import io.realworld.api.models.requests.UserCreds
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Assert.assertNotNull
import kotlin.random.Random


class ConduitClientTest {

    private val conduitClient = ConduitClient()


    //Test for Articles
    @Test
    fun `get Articles`() {

        runBlocking {

            val articles = conduitClient.api.getArtciles()
            assertNotNull(articles.body()?.articles)

        }

    }

    //Test for Articles by author
    @Test
    fun `get Articles by author`() {

        runBlocking {

            val articles = conduitClient.api.getArtciles(author = "cy271839439")
            assertNotNull(articles.body()?.articles)

        }

    }

    //Test for Articles by tags
    @Test
    fun `get Articles by tags`() {

        runBlocking {

            val articles = conduitClient.api.getArtciles(tag = "butts")
            assertNotNull(articles.body()?.articles)

        }
    }



    //Test for user signUp
    @Test
    fun `POST users - create user`() {

        runBlocking {

            val userCreds = UserCreds(
                email = "testemail${Random.nextInt(999, 9999)}@test.com",
                password = "pass${Random.nextInt(999,99999)}"
            )

            val resp = conduitClient.api.signupUser(SignupRequest(userCreds))
            assertEquals(userCreds.username, resp.body()?.user?.username)
        }
    }
}

