package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CountNumberOfNiceSubarraysTest {

    @Test
    fun `test count result`() {
        val subarrays = CountNumberOfNiceSubarrays()

        assertEquals(16, subarrays.numberOfSubarrays(intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2), 2))

        assertEquals(19, subarrays.numberOfSubarrays(intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1), 2))

    }


}