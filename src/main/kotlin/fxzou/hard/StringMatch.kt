package fxzou.hard

/**
 * https://leetcode-cn.com/problems/wildcard-matching/
 */

class StringMatch {

    fun isMatch(s: String, p: String): Boolean {
        val cache = Array(s.length + 1) { IntArray(p.length + 1) }
        return matchHelper(0, 0, s.toCharArray(), p.toCharArray(), cache)
    }

    private fun matchHelper(
        strStartIndex: Int,
        pStartIndex: Int,
        str: CharArray,
        p: CharArray,
        cache: Array<IntArray>
    ): Boolean {
        if (cache[strStartIndex][pStartIndex] != 0) {
            return false
        }
        if (strStartIndex >= str.size && pStartIndex >= p.size) {
            return true
        }
        if (pStartIndex == p.size - 1 && p[pStartIndex] == '*') {
            return true
        }
        if (pStartIndex < p.size && p[pStartIndex] == '*') {
            for (i in strStartIndex..str.size) {
                val matchResult = matchHelper(i, pStartIndex + 1, str, p, cache)
                if (matchResult) {
                    return true
                }
            }
            cache[strStartIndex][pStartIndex] = 1
            return false
        }
        if (strStartIndex >= str.size || pStartIndex >= p.size) {
            cache[strStartIndex][pStartIndex] = 1
            return false
        }
        if (p[pStartIndex] == '?') {
            return matchHelper(strStartIndex + 1, pStartIndex + 1, str, p, cache)
        }
        if (p[pStartIndex] == str[strStartIndex]) {
            return matchHelper(strStartIndex + 1, pStartIndex + 1, str, p, cache)
        }
        cache[strStartIndex][pStartIndex] = 1
        return false
    }
}