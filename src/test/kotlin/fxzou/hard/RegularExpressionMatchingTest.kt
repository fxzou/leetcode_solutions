package fxzou.hard

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RegularExpressionMatchingTest {

    @Test
    fun `match true test`() {
        val match = RegularExpressionMatching()
        assertTrue(match.isMatch("", ""))
        assertTrue(match.isMatch("a", "a"))
        assertTrue(match.isMatch("a", "a*"))
        assertTrue(match.isMatch("", "a*"))
        assertTrue(match.isMatch("abcd", ".*"))
        assertTrue(match.isMatch("aab", ".*b*a*b"))
        assertTrue(match.isMatch("a", "."))
    }

    @Test
    fun `match false test`() {
        val match = RegularExpressionMatching()
        assertFalse(match.isMatch("aab", "aac"))
        assertFalse(match.isMatch("aab", ".*aac"))
        assertFalse(match.isMatch("aab", "a*c"))
        assertFalse(match.isMatch("a", ".*..a"))
    }


}