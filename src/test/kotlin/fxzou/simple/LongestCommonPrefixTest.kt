package fxzou.simple

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LongestCommonPrefixTest {

    @Test
    fun `test result`() {
        val answer = LongestCommonPrefix()

        assertEquals("fl", answer.longestCommonPrefix(arrayOf("flower", "flow", "flight")))

        assertEquals("", answer.longestCommonPrefix(arrayOf("dog", "racecar", "car")))

        assertEquals("", answer.longestCommonPrefix(arrayOf()))

        assertEquals("dog", answer.longestCommonPrefix(arrayOf("dog")))

    }

}