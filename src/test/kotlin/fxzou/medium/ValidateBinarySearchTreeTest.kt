package fxzou.medium

import fxzou.common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ValidateBinarySearchTreeTest {

    @Test
    fun `test search result`() {
        val search = ValidateBinarySearchTree()

        assertFalse(search.isValidBST(TreeNode.parse(listOf(5, 1, 4, null, null, 3, 6))))

        assertFalse(search.isValidBST(TreeNode.parse(listOf(4, 1, 5, null, null, 3, 6))))

        assertTrue(search.isValidBST(TreeNode.parse(listOf(3, 1, 5, null, null, 4, 6))))

        assertTrue(search.isValidBST(TreeNode.parse(listOf(3, 1, 5, null, null, 4, null))))
    }

}