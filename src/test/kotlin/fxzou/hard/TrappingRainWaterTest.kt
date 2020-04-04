package fxzou.hard

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TrappingRainWaterTest {

    @Test
    fun `test trap`() {
        assertEquals(0, TrappingRainWater().trap(intArrayOf()))
        assertEquals(6, TrappingRainWater().trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
        assertEquals(1, TrappingRainWater().trap(intArrayOf(2, 1, 2)))
    }

}