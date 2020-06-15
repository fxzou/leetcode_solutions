package fxzou.simple

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
class LongestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        return strs.reduce{ str1, str2 ->
            str1.commonPrefixWith(str2)
        }
    }

}