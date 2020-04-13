package fxzou.medium

import java.util.*


/**
 * https://leetcode-cn.com/problems/design-twitter/
 */
class DesignTwitter {
    var seq: Int
    var postMap: MutableMap<Int, LinkedList<Pair<Int, Int>>>
    var followerMap: MutableMap<Int, MutableSet<Int>>

    /** Initialize your data structure here. */
    init {
        seq = 0
        postMap = hashMapOf()
        followerMap = hashMapOf()
    }

    /** Compose a new tweet. */
    fun postTweet(userId: Int, tweetId: Int) {
        val posts = postMap.get(userId)
        val twitter = Pair(seq++, tweetId)
        if (posts == null) {
            val newPosts = LinkedList<Pair<Int, Int>>()
            newPosts.add(twitter)
            postMap.put(userId, newPosts)
        } else {
            posts.addFirst(twitter)
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    fun getNewsFeed(userId: Int): List<Int> {
        val follwers = followerMap.get(userId) ?: hashSetOf(userId)
        val iterators = follwers
            .map { postMap.get(it) }
            .filterNotNull()
            .map { Pair(it, it.listIterator()) }
        val result = mutableListOf<Int>()
        while (result.size < 10) {
            val maxSeqPosts = iterators.maxBy {
                if (it.second.hasNext()) it.first.get(it.second.nextIndex()).first else Int.MIN_VALUE
            }
            if (maxSeqPosts == null || !maxSeqPosts.second.hasNext()) {
                break
            }
            result.add(maxSeqPosts.second.next().second)
        }
        return result
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    fun follow(followerId: Int, followeeId: Int) {
        val followers = followerMap.get(followerId)
        if (followers == null) {
            followerMap.put(followerId, mutableSetOf(followerId, followeeId))
        } else {
            followers.add(followeeId)
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    fun unfollow(followerId: Int, followeeId: Int) {
        if (followeeId != followerId) {
            followerMap.get(followerId)?.remove(followeeId)
        }
    }

}