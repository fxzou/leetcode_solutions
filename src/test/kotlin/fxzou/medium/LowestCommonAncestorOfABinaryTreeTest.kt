package fxzou.medium

import fxzou.common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LowestCommonAncestorOfABinaryTreeTest {

    @Test
    fun `test result`() {
        val tree = TreeNode.parse(listOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4))

        assertEquals(
            TreeNode(3),
            LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(tree, TreeNode(5), TreeNode(1))
        )
        assertEquals(
            TreeNode(3),
            LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(tree, TreeNode(1), TreeNode(5))
        )

        assertEquals(
            TreeNode(5),
            LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(tree, TreeNode(5), TreeNode(4))
        )

        assertEquals(
            TreeNode(3),
            LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(tree, TreeNode(7), TreeNode(8))
        )
    }

}