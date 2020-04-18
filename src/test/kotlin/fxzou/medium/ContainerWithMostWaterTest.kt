package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ContainerWithMostWaterTest {

    @Test
    fun `test result`() {

        val containerWithMostWater = ContainerWithMostWater()

        assertEquals(49, containerWithMostWater.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))

    }

}