package fxzou.hard

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SuperEggDropTest {

    @Test
    fun `test drop`() {
        assertEquals(2, SuperEggDrop().superEggDrop(1, 2))
        assertEquals(3, SuperEggDrop().superEggDrop(2, 6))
        assertEquals(4, SuperEggDrop().superEggDrop(3, 14))
    }

}