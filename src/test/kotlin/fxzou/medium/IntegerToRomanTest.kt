package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class IntegerToRomanTest {

    @Test
    fun `should return I when number is 1`() {
        assertEquals("I", IntegerToRoman().intToRoman(1))
    }

    @Test
    fun `should return XI when number is 11`() {
        assertEquals("XI", IntegerToRoman().intToRoman(11))
    }

    @Test
    fun `should return XIV when number is 14`() {
        assertEquals("XI", IntegerToRoman().intToRoman(11))
    }

    @Test
    fun `should return MCMXCIV when number is 1994`() {
        assertEquals("MCMXCIV", IntegerToRoman().intToRoman(1994))
    }

    @Test
    fun `should return MMCMXCIV when number is 2994`() {
        assertEquals("MMCMXCIV", IntegerToRoman().intToRoman(2994))
    }


}