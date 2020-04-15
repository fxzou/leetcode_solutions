package fxzou.medium

import fxzou.common.ListNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SplitListToPartsTest {

    @Test
    fun `test split`() {

        val source = ListNode.parse("1->2->3->4->5")

        val result = SplitListToParts().splitListToParts(source, 3).map { it.toString() }

        assertThat(result).containsSequence(
            "1->2",
            "3->4",
            "5"
        )

    }

}