package fxzou.hard

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 */

class RegularExpressionMatching {

    fun isMatch(s: String, p: String): Boolean {
        val matchMap = Array(s.length + 1, { BooleanArray(p.length + 1, { false }) })
        for (j in p.indices) {
            if (j < p.length - 1 && p[j + 1] == '*') continue
            if (p[j] != '*') break
            matchMap[0][j + 1] = true
        }
        matchMap[0][0] = true
        for (i in s.indices) {
            for (j in p.indices) {
                if (j < p.length - 1 && p[j + 1] == '*') continue
                if (p[j] == '.') {
                    matchMap[i + 1][j + 1] = matchMap[i][j]
                    continue
                }
                if (p[j] == '*') {
                    if (p[j - 1] == '.') {
                        matchMap[i + 1][j + 1] = matchMap[i + 1][j - 1] || matchMap[i][j + 1]
                    } else {
                        matchMap[i + 1][j + 1] =
                            if (s[i] == p[j - 1]) matchMap[i + 1][j - 1] || matchMap[i][j + 1] else matchMap[i + 1][j - 1]
                    }
                    continue
                }
                matchMap[i + 1][j + 1] = if (s[i] == p[j]) matchMap[i][j] else false
            }
        }
        return matchMap[s.length][p.length]
    }

}