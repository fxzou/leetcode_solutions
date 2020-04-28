package fxzou.medium

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SingleNumberInNumberArrayTest {

    @Test
    fun `test result`() {
        val result = SingleNumberInNumberArray().singleNumbers(intArrayOf(1, 2, 10, 4, 1, 4, 3, 3))
        assertThat(result).containsExactlyInAnyOrder(2, 10)
    }

}