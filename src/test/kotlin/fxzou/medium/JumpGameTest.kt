package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class JumpGameTest {

    @Test
    fun `test jump`() {
        val jumpGame = JumpGame()

        assertTrue(jumpGame.canJump(intArrayOf(2, 3, 1, 1, 4)))
        assertTrue(jumpGame.canJump(intArrayOf(2)))

        assertFalse(jumpGame.canJump(intArrayOf(3, 2, 1, 0, 4)))
        assertFalse(jumpGame.canJump(intArrayOf(0, 1)))
    }

}