package fxzou.simple

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SingleNumberTest {

    @Test
    fun `test result`() {
        assertEquals(1, SingleNumber().singleNumber(intArrayOf(1, 2, 2, 3, 3)))
    }

}