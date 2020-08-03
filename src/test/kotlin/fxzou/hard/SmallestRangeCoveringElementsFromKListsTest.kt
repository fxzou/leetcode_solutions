package fxzou.hard

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SmallestRangeCoveringElementsFromKListsTest {

    @Test
    fun `test result`() {
        val ans = SmallestRangeCoveringElementsFromKLists()

        assertArrayEquals(
            intArrayOf(20, 24), ans.smallestRange(
                listOf(
                    listOf(4, 10, 15, 24, 26),
                    listOf(0, 9, 10, 12, 20),
                    listOf(5, 18, 22, 30)
                )
            )
        )

        assertArrayEquals(
            intArrayOf(4, 4), ans.smallestRange(
                listOf(
                    listOf(4, 10, 15, 24, 26)
                )
            )
        )

    }

}