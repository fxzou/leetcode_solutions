package fxzou.medium

import fxzou.common.ListNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class AddTwoNumbers2Test {

    @Test
    fun `test add result`() {
        val num1 = ListNode.parse("7->2->4->3")

        val num2 = ListNode.parse("5->6->4")

        Assertions.assertThat(AddTwoNumbers2().addTwoNumbers(num1, num2).toString()).isEqualTo("7->8->0->7")
    }


    @Test
    fun `test add result 2`() {
        val num1 = ListNode.parse("7->2->4->3")

        val num2 = ListNode.parse("5->5->6->4")

        Assertions.assertThat(AddTwoNumbers2().addTwoNumbers(num1, num2).toString()).isEqualTo("1->2->8->0->7")
    }

}