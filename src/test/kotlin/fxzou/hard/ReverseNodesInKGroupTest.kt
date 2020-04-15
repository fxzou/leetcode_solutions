package fxzou.hard

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReverseNodesInKGroupTest {

    @Test
    fun `test reverse`() {
        val group = ReverseNodesInKGroup()

        var head = ReverseNodesInKGroup.ListNode(5)
        head = ReverseNodesInKGroup.ListNode(4).also { it.next = head }
        head = ReverseNodesInKGroup.ListNode(3).also { it.next = head }
        head = ReverseNodesInKGroup.ListNode(2).also { it.next = head }
        head = ReverseNodesInKGroup.ListNode(1).also { it.next = head }

        assertThat(group.reverseKGroup(head, 2).toString()).isEqualTo("2->1->4->3->5")

        head = ReverseNodesInKGroup.ListNode(5)
        head = ReverseNodesInKGroup.ListNode(4).also { it.next = head }
        head = ReverseNodesInKGroup.ListNode(3).also { it.next = head }
        head = ReverseNodesInKGroup.ListNode(2).also { it.next = head }
        head = ReverseNodesInKGroup.ListNode(1).also { it.next = head }

        assertThat(group.reverseKGroup(head, 3).toString()).isEqualTo("3->2->1->4->5")

        head = ReverseNodesInKGroup.ListNode(8)
        head = ReverseNodesInKGroup.ListNode(7).also { it.next = head }
        head = ReverseNodesInKGroup.ListNode(6).also { it.next = head }
        head = ReverseNodesInKGroup.ListNode(5).also { it.next = head }
        head = ReverseNodesInKGroup.ListNode(4).also { it.next = head }
        head = ReverseNodesInKGroup.ListNode(3).also { it.next = head }
        head = ReverseNodesInKGroup.ListNode(2).also { it.next = head }
        head = ReverseNodesInKGroup.ListNode(1).also { it.next = head }

        assertThat(group.reverseKGroup(head, 3).toString()).isEqualTo("3->2->1->6->5->4->7->8")

    }

}