package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Matrix01Test {

    @Test
    fun `test update`() {
        val source = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1)
        )

        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 2, 1)
        )

        assertArrayEquals(expected, Matrix01().updateMatrix(source))

    }

    @Test
    fun `test single`() {
        val source = arrayOf(
            intArrayOf(0)
        )

        val expected = arrayOf(
            intArrayOf(0)
        )

        assertArrayEquals(expected, Matrix01().updateMatrix(source))

    }

}