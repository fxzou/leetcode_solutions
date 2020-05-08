package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MaximalSquareTest {

    @Test
    fun `test result`() {
        val square = MaximalSquare()

        val source = arrayOf(
            charArrayOf('1', '0', '1', '0', '0'),
            charArrayOf('1', '0', '1', '1', '1'),
            charArrayOf('1', '1', '1', '1', '1'),
            charArrayOf('1', '0', '0', '1', '0')
        )

        assertEquals(4, square.maximalSquare(source))
    }

    @Test
    fun `test result 2`() {
        val square = MaximalSquare()

        val source = arrayOf(
            charArrayOf('0', '0', '0', '1'),
            charArrayOf('1', '1', '0', '1'),
            charArrayOf('1', '1', '1', '1'),
            charArrayOf('0', '1', '1', '1'),
            charArrayOf('0', '1', '1', '1')
        )

        assertEquals(9, square.maximalSquare(source))
    }

    @Test
    fun `test result 3`() {
        val square = MaximalSquare()

        val source = arrayOf(
            charArrayOf('1', '1', '1', '0', '1'),
            charArrayOf('1', '0', '0', '0', '0'),
            charArrayOf('1', '0', '0', '0', '0'),
            charArrayOf('1', '0', '0', '0', '0')
        )

        assertEquals(1, square.maximalSquare(source))
    }

}