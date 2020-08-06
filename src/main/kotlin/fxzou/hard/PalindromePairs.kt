package fxzou.hard

import java.util.*
import kotlin.collections.HashMap

/**
 * https://leetcode-cn.com/problems/palindrome-pairs/
 */
class PalindromePairs {

    fun palindromePairs(words: Array<String>): List<List<Int>> {
        val indices = HashMap<String, Int>()
        for (i in words.indices) {
            indices.put(words[i].reversed(), i);
        }
        val result = LinkedList<List<Int>>()
        for (i in words.indices) {
            val word = words[i]
            if (word.isEmpty()) continue
            if (isPalindromeString(word) && indices.containsKey("")) {
                result.add(listOf(i, indices.getValue("")))
                result.add(listOf(indices.getValue(""), i))
            }
            if (indices.containsKey(word) && indices.getValue(word) != i) {
                result.add(listOf(i, indices.getValue(word)))
            }
            for (m in 1..word.length - 1) {
                val left = word.substring(0, m)
                val right = word.substring(m, word.length)
                if (indices.containsKey(left) && isPalindromeString(right)) {
                    result.add(listOf(i, indices.getValue(left)))
                }
                if (indices.containsKey(right) && isPalindromeString(left)) {
                    result.add(listOf(indices.getValue(right), i))
                }
            }

        }
        return result
    }

    private fun isPalindromeString(str: String): Boolean {
        var left = 0
        var right = str.length - 1
        while (left <= right) {
            if (str[left] != str[right]) return false
            left++
            right--
        }
        return true
    }


}