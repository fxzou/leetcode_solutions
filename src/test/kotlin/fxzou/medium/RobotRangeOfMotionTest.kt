package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RobotRangeOfMotionTest {

    @Test
    fun `test count`() {
        val robot = RobotRangeOfMotion()

        assertEquals(3, robot.movingCount(2, 3, 1))

        assertEquals(1, robot.movingCount(3, 1, 0))

    }

}