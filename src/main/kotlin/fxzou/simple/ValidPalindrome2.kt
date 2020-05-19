package fxzou.simple

class ValidPalindrome2 {

    fun validPalindrome(s: String): Boolean {
        return validHelper(s, 0, s.length - 1, false)
    }

    private fun validHelper(s: String, left: Int, right: Int, deleted: Boolean): Boolean {
        if (left >= right) {
            return true
        }
        if (s[left] == s[right]) {
            return validHelper(s, left + 1, right - 1, deleted)
        }
        if (deleted) {
            return false
        }
        return validHelper(s, left + 1, right, true) || validHelper(s, left, right - 1, true)
    }

}