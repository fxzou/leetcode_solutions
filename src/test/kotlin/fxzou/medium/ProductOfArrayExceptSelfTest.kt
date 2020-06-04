package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ProductOfArrayExceptSelfTest {

    @Test
    fun `should return correct result`() {

        assertArrayEquals(
            intArrayOf(24, 12, 8, 6),
            ProductOfArrayExceptSelf().productExceptSelf(intArrayOf(1, 2, 3, 4))
        )


    }

}