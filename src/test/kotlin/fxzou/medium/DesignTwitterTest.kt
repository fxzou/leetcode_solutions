package fxzou.medium

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DesignTwitterTest {

    @Test
    fun `test twitter`() {
        val twitter = DesignTwitter()

        twitter.postTweet(1, 5)

        assertThat(twitter.getNewsFeed(1)).containsSequence(5)

        twitter.follow(1, 2)

        twitter.postTweet(2, 6)
        twitter.postTweet(2, 3)

        assertThat(twitter.getNewsFeed(1)).containsSequence(3, 6, 5)

        twitter.unfollow(1, 2)

        assertThat(twitter.getNewsFeed(1)).containsSequence(5)
    }

}