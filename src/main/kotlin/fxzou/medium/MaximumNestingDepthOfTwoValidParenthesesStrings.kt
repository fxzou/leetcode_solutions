package fxzou.medium

import java.util.*

/**
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 */

class MaximumNestingDepthOfTwoValidParenthesesStrings {

    fun maxDepthAfterSplit(seq: String): IntArray {
        val maxDepth = maxDepth(seq)
        val maxDepthAfterSplit = maxDepth - maxDepth / 2
        val result = IntArray(seq.length)
        var nextDepth = 1
        for (i in seq.indices) {
            var currentDepth = nextDepth
            if (seq[i] == '(') {
                nextDepth++
            } else {
                currentDepth = nextDepth - 1
                nextDepth--
            }
            result[i] = if (currentDepth > maxDepthAfterSplit) 1 else 0
        }
        return result
    }

    fun maxDepth(seq: String): Int {
        var maxDepth = 0
        var nextDepth = 1
        for (i in seq.indices) {
            if (seq[i] == '(') {
                maxDepth = Math.max(maxDepth, nextDepth)
                nextDepth++
            } else {
                maxDepth = Math.max(maxDepth, nextDepth - 1)
                nextDepth--
            }
        }
        return maxDepth
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Arrays.toString(MaximumNestingDepthOfTwoValidParenthesesStrings().maxDepthAfterSplit("()()()()")))
            println(Arrays.toString(MaximumNestingDepthOfTwoValidParenthesesStrings().maxDepthAfterSplit("(()())")))
        }
    }
}

