package fxzou.simple

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SqrtxTest {

    @Test
    fun `test sqrt`() {
        assertEquals(2, Sqrtx().mySqrt(8))

        assertEquals(3, Sqrtx().mySqrt(9))

        assertEquals(1, Sqrtx().mySqrt(1))

    }

}