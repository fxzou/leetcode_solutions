package fxzou.medium

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GenerateParenthesesTest {

    @Test
    fun `test generate`() {
        val expected = listOf(
            "(((())))",
            "((()()))",
            "((())())",
            "((()))()",
            "(()(()))",
            "(()()())",
            "(()())()",
            "(())(())",
            "(())()()",
            "()((()))",
            "()(()())",
            "()(())()",
            "()()(())",
            "()()()()"
        )

        val result = GenerateParentheses().generateParenthesis(4)

        assertThat(result).containsExactlyInAnyOrderElementsOf(expected)

    }

    @Test
    fun `should return empty when n is 0`() {

        val result = GenerateParentheses().generateParenthesis(0)

        assertThat(result).isEmpty()

    }

}