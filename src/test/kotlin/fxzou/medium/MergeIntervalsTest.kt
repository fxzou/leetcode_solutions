package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MergeIntervalsTest {

    @Test
    fun `test merge`() {
        val source = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 6),
            intArrayOf(8, 10),
            intArrayOf(15, 18)
        )

        val expected = arrayOf(
            intArrayOf(1, 6),
            intArrayOf(8, 10),
            intArrayOf(15, 18)
        )

        assertArrayEquals(expected, MergeIntervals().merge(source))

    }

    @Test
    fun `test duplicate item`() {
        val source = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 6),
            intArrayOf(6, 10),
            intArrayOf(15, 18),
            intArrayOf(16, 17)
        )

        val expected = arrayOf(
            intArrayOf(1, 10),
            intArrayOf(15, 18)
        )

        assertArrayEquals(expected, MergeIntervals().merge(source))

    }

}