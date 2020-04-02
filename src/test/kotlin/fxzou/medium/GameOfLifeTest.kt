package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GameOfLifeTest {

    @Test
    fun `should refresh once` () {
        val board = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 0)
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(1, 0, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 1, 0)
        )
        GameOfLife().gameOfLife(board)

        assertArrayEquals(expected, board)

    }

}