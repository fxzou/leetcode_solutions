package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MinimumPathSumTest {

    @Test
    fun `test result`() {
        val grid = arrayOf(
            intArrayOf(1, 3, 1),
            intArrayOf(1, 5, 1),
            intArrayOf(4, 2, 1)
        )

        assertEquals(7, MinimumPathSum().minPathSum(grid))
    }

}