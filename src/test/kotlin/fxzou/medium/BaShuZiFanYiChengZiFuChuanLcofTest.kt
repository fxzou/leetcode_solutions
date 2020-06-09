package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BaShuZiFanYiChengZiFuChuanLcofTest {

    @Test
    fun `test result`() {
        val answer = BaShuZiFanYiChengZiFuChuanLcof()
        assertEquals(5, answer.translateNum(12258))

        assertEquals(1, answer.translateNum(0))

        assertEquals(2, answer.translateNum(11))

        assertEquals(1, answer.translateNum(506))

    }

}