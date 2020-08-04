package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CourseScheduleTest {

    @Test
    fun `test result`() {
        val ans = CourseSchedule()

        assertTrue(ans.canFinish(
            6, arrayOf(
                intArrayOf(1, 0),
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(4, 3),
                intArrayOf(5, 1)
            )
        ))

        assertFalse(ans.canFinish(
            6, arrayOf(
                intArrayOf(1, 0),
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(4, 3),
                intArrayOf(5, 1),
                intArrayOf(2, 5)
            )
        ))
    }

}