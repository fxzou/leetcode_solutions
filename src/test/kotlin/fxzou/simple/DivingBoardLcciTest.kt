package fxzou.simple

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DivingBoardLcciTest {
    @Test
    fun `test result`() {
        assertArrayEquals(intArrayOf(3,4,5,6), DivingBoardLcci().divingBoard(1, 2, 3))
    }
}