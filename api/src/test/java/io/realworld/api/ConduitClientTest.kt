package io.realworld.api

import org.junit.Test
import org.junit.Assert.assertNotNull


class ConduitClientTest {

    private val conduitClient = ConduitClient()


    //Test for Articles
    @Test
    fun `get Articles`() {

        val articles = conduitClient.api.getArtciles().execute()
        assertNotNull(articles.body()?.articles)

    }

    //Test for tags
    @Test
    fun `get Tags`() {

        val tags = conduitClient.api.getTags().execute()
        assertNotNull(tags.body()?.tags)
    }

}