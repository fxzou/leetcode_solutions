package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StringToIntegerAtoiTest {

    @Test
    fun `should return 0 when string is empty`() {
        assertEquals(0, StringToIntegerAtoi().myAtoi(""))

    }

    @Test
    fun `should return 1 when string is '1'`() {
        assertEquals(1, StringToIntegerAtoi().myAtoi("1"))

    }

    @Test
    fun `should return 10 when string is '10'`() {
        assertEquals(10, StringToIntegerAtoi().myAtoi("10"))

    }

    @Test
    fun `should return -100 when string is '-100'`() {
        assertEquals(-100, StringToIntegerAtoi().myAtoi("-100"))
    }

    @Test
    fun `should return -100 when string is '  -100'`() {
        assertEquals(-100, StringToIntegerAtoi().myAtoi("  -100"))
    }

    @Test
    fun `should return 0 when string is ' a -100'`() {
        assertEquals(0, StringToIntegerAtoi().myAtoi(" a -100"))
    }

    @Test
    fun `should return -100 when string is '  -100 aaa'`() {
        assertEquals(-100, StringToIntegerAtoi().myAtoi("  -100  aa"))
    }

    @Test
    fun `should return -2147483648 when string is '-91283472332'`() {
        assertEquals(-2147483648, StringToIntegerAtoi().myAtoi("-91283472332"))
    }

    @Test
    fun `should return 2147483647 when string is '91283472332'`() {
        assertEquals(2147483647, StringToIntegerAtoi().myAtoi("91283472332"))
    }

    @Test
    fun `should return 3213 when string is '  3213 asd'`() {
        assertEquals(3213, StringToIntegerAtoi().myAtoi("  3213 asd"))
    }

    @Test
    fun `should return 123 when string is '+123'`() {
        assertEquals(123, StringToIntegerAtoi().myAtoi("+123"))
    }

    @Test
    fun `should return 0 when string is '++123'`() {
        assertEquals(0, StringToIntegerAtoi().myAtoi("++123"))
    }

    @Test
    fun `should return 0 when string is '--123'`() {
        assertEquals(0, StringToIntegerAtoi().myAtoi("--123"))
    }
}