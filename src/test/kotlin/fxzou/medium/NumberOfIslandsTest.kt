package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NumberOfIslandsTest {

    @Test
    fun `test result`() {

        val source = arrayOf(
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '1')
        )

        assertEquals(3, NumberOfIslands().numIslands(source))

    }

    @Test
    fun `test result 2`() {

        val source = arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '1', '1', '1', '1')
        )

        assertEquals(2, NumberOfIslands().numIslands(source))

    }


}