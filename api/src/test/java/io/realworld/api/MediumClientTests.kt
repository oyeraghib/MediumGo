package io.realworld.api

import com.example.api.MediumClient
import org.junit.Test
import org.junit.Assert.assertNotNull



class MediumClientTests {
    private val mediumClient = MediumClient()

    @Test
    fun `GET articles`() {
        val articles = mediumClient.api.getArticles().execute()
        assertNotNull(articles.body()?.article)
    }
}