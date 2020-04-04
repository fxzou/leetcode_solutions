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
        if (pStartIndex < p.size && p[pStartIndex] == '*') {
            var lastAlmightyIndex = pStartIndex
            while (true) {
                if (lastAlmightyIndex + 1 >= p.size || p[lastAlmightyIndex + 1] != '*') break
                lastAlmightyIndex++
            }
            if (lastAlmightyIndex == p.size - 1) {
                return true
            }
            if (
                (strStartIndex..str.size).any {
                    matchHelper(it, lastAlmightyIndex + 1, str, p, cache)
                }
            ) return true
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