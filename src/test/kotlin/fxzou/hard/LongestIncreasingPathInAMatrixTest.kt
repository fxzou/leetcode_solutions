package fxzou.hard

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LongestIncreasingPathInAMatrixTest {

    @Test
    fun `test result`() {
        val answer = LongestIncreasingPathInAMatrix()

        assertEquals(
            4, answer.longestIncreasingPath(
                arrayOf(
                    intArrayOf(9, 9, 4),
                    intArrayOf(6, 6, 8),
                    intArrayOf(2, 1, 1)
                )
            )
        )

        assertEquals(
            4, answer.longestIncreasingPath(
                arrayOf(
                    intArrayOf(3, 4, 5),
                    intArrayOf(3, 2, 6),
                    intArrayOf(2, 2, 1)
                )
            )
        )
    }


}