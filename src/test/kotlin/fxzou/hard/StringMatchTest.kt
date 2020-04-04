package fxzou.hard

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StringMatchTest {

    @Test
    fun `should return true when match success`() {
        val match = StringMatch()

        assertTrue(match.isMatch("", ""))
        assertTrue(match.isMatch("", "*"))
        assertTrue(match.isMatch("a", "*"))
        assertTrue(match.isMatch("a", "**a"))
        assertTrue(match.isMatch("a", "**?"))
        assertTrue(match.isMatch("abc", "abc"))
        assertTrue(match.isMatch("abcd", "abc**"))
        assertTrue(match.isMatch("abcdddd", "a******bc**"))


    }

    @Test
    fun `should return false when match fail`() {
        val match = StringMatch()

        assertFalse(match.isMatch("abc", "abd"))
        assertFalse(match.isMatch("abc", "*abd"))
        assertFalse(match.isMatch("abc", ""))
        assertFalse(match.isMatch("abcdddd", "a******bc**e"))


    }


}