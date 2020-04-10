package fxzou.medium

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
class ReverseWordsInAString {

    fun reverseWords(s: String): String {
        if (s.isBlank()) return ""
        return s.split(" ")
            .filter { it.isNotBlank() }
            .asReversed()
            .joinToString(" ")
    }

}