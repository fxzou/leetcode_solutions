package fxzou.hard

import fxzou.common.ListNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ReverseNodesInKGroupTest {

    @Test
    fun `test reverse`() {
        val group = ReverseNodesInKGroup()

        var head = ListNode.parse("1->2->3->4->5")

        assertThat(group.reverseKGroup(head, 2).toString()).isEqualTo("2->1->4->3->5")

        head = ListNode.parse("1->2->3->4->5")

        assertThat(group.reverseKGroup(head, 3).toString()).isEqualTo("3->2->1->4->5")

        head = ListNode.parse("1->2->3->4->5->6->7->8")

        assertThat(group.reverseKGroup(head, 3).toString()).isEqualTo("3->2->1->6->5->4->7->8")

    }

}