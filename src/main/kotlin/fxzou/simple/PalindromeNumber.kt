package fxzou.simple

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 */
class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        var temp = x
        var rx = 0
        while (temp != 0) {
            rx = rx * 10 + temp % 10
            temp /= 10
        }
        return x == rx
    }
}