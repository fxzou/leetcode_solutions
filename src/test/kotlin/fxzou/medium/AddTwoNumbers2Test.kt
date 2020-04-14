package fxzou.medium

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class AddTwoNumbers2Test {

    @Test
    fun `test add result`() {
        var num1 = AddTwoNumbers2.ListNode(3)
        num1 = AddTwoNumbers2.ListNode(4).also { it.next = num1 }
        num1 = AddTwoNumbers2.ListNode(2).also { it.next = num1 }
        num1 = AddTwoNumbers2.ListNode(7).also { it.next = num1 }

        var num2 = AddTwoNumbers2.ListNode(4)
        num2 = AddTwoNumbers2.ListNode(6).also { it.next = num2 }
        num2 = AddTwoNumbers2.ListNode(5).also { it.next = num2 }

        Assertions.assertThat(AddTwoNumbers2().addTwoNumbers(num1, num2).toString()).isEqualTo("7807")
    }


    @Test
    fun `test add result 2`() {
        var num1 = AddTwoNumbers2.ListNode(3)
        num1 = AddTwoNumbers2.ListNode(4).also { it.next = num1 }
        num1 = AddTwoNumbers2.ListNode(2).also { it.next = num1 }
        num1 = AddTwoNumbers2.ListNode(7).also { it.next = num1 }

        var num2 = AddTwoNumbers2.ListNode(4)
        num2 = AddTwoNumbers2.ListNode(6).also { it.next = num2 }
        num2 = AddTwoNumbers2.ListNode(5).also { it.next = num2 }
        num2 = AddTwoNumbers2.ListNode(5).also { it.next = num2 }

        Assertions.assertThat(AddTwoNumbers2().addTwoNumbers(num1, num2).toString()).isEqualTo("12807")
    }

}