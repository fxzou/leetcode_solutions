package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ReverseWordsInAStringTest {

    @Test
    fun `return empty when string is blank`() {
        assertEquals("", ReverseWordsInAString().reverseWords("             "))
        assertEquals("", ReverseWordsInAString().reverseWords(""))
    }

    @Test
    fun `return reverse words string`() {
        assertEquals("Java world! hello", ReverseWordsInAString().reverseWords("  hello   world! Java "))
    }

}