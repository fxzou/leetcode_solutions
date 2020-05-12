package fxzou.simple

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MinStackTest {

    @Test
    fun `test min stack`() {
        val minStack = MinStack()

        minStack.push(2)
        minStack.push(1)
        minStack.push(1)
        minStack.push(3)

        assertEquals(1, minStack.getMin())
        assertEquals(3, minStack.top())
        minStack.pop()
        assertEquals(1, minStack.top())
        minStack.pop()
        assertEquals(1, minStack.getMin())
        minStack.pop()
        assertEquals(2, minStack.getMin())

    }

}