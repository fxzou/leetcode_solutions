package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class UniquePaths2Test {

    @Test
    fun `test result`() {
        val ans = UniquePaths2()

        assertEquals(
            2, ans.uniquePathsWithObstacles(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                )
            )
        )

        assertEquals(
            1, ans.uniquePathsWithObstacles(
                arrayOf(
                    intArrayOf(0, 0, 0)
                )
            )
        )

        assertEquals(
            1, ans.uniquePathsWithObstacles(
                arrayOf(
                    intArrayOf(0)
                )
            )
        )

        assertEquals(
            0, ans.uniquePathsWithObstacles(
                arrayOf(
                    intArrayOf(0, 1, 0)
                )
            )
        )

        assertEquals(
            0, ans.uniquePathsWithObstacles(
                arrayOf(
                    intArrayOf(1)
                )
            )
        )


    }

}