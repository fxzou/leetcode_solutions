package fxzou.medium

import fxzou.common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryTreeLevelOrderTraversalTest {

    @Test
    fun `test result`() {
        val tree = TreeNode.parse(listOf(3, 9, 20, null, null, 15, 7))

        assertEquals(
            listOf(
                listOf(3),
                listOf(9, 20),
                listOf(15, 7)
            ),
            BinaryTreeLevelOrderTraversal().levelOrder(tree)
        )
    }
}