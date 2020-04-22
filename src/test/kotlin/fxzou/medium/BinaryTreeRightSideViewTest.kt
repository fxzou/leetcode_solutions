package fxzou.medium

import fxzou.common.TreeNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BinaryTreeRightSideViewTest {

    @Test
    fun `test view result`() {
        val binaryTreeRightSideView = BinaryTreeRightSideView()

        val tree1 = TreeNode.parse(listOf(1, 2, 3, null, 5, null, 4, 6, 7, 8, 9))

        assertThat(binaryTreeRightSideView.rightSideView(tree1)).containsSequence(1, 3, 4, 9)

        val tree2 = TreeNode.parse(listOf(1, 2, 3, null, 5, null, 4, 6, 7, 8, 9, 3))

        assertThat(binaryTreeRightSideView.rightSideView(tree2)).containsSequence(1, 3, 4, 9, 3)

        val tree3 = TreeNode.parse(listOf(1, 2, 3, null, 5, 6))

        assertThat(binaryTreeRightSideView.rightSideView(tree3)).containsSequence(1, 3, 6)
    }


}