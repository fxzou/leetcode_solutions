package fxzou.common

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ListNodeTest {

    @Test
    fun `test list node parse and to string`() {
        assertEquals("1->2->3", ListNode.parse("1->2->3").toString())
        assertEquals("1", ListNode.parse("1").toString())
    }

}