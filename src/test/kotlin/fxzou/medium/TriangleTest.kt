package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TriangleTest {

    @Test
    fun `test result`() {
        val triangle = listOf(
            listOf(2),
            listOf(3, 4),
            listOf(6, 5, 7),
            listOf(4, 1, 8, 3)
        )

        assertEquals(11, Triangle().minimumTotal(triangle))

    }


}