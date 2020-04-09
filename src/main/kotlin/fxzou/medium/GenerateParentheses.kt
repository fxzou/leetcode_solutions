package fxzou.medium

import java.util.*

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */

class GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        if (n < 1) {
            return emptyList()
        }
        val cache = mutableMapOf(0 to listOf(""))
        for (i in 1..n) {
            val temp = LinkedList<String>()
            for (j in 0..i - 1) {
                for (l in cache.get(j)!!)
                    for (r in cache.get(i - j - 1)!!) {
                        temp.add("(" + l + ")" + r)
                    }
            }
            cache.put(i, temp)
        }
        return cache.get(n)!!
    }
}