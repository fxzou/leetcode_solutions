package fxzou.simple

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PalindromeNumberTest {

    @Test
    fun `test true`() {
        val ans = PalindromeNumber()
        assertTrue(ans.isPalindrome(121))
        assertTrue(ans.isPalindrome(12321))
        assertTrue(ans.isPalindrome(0))
    }

    @Test
    fun `test false`() {
        val ans = PalindromeNumber()
        assertFalse(ans.isPalindrome(-121))
        assertFalse(ans.isPalindrome(1232100))
        assertFalse(ans.isPalindrome(12331))

    }

}