package fxzou.medium

import fxzou.common.TreeNode

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result: MutableList<MutableList<Int>> = mutableListOf()
        iterateHelper(root, 0, result)
        return result
    }

    private fun iterateHelper(node: TreeNode?, depth: Int, result: MutableList<MutableList<Int>>) {
        if (node == null) return
        if (depth == result.size) {
            result.add(mutableListOf(node.`val`))
        } else {
            result[depth].add(node.`val`)
        }
        iterateHelper(node.left, depth + 1, result)
        iterateHelper(node.right, depth + 1, result)
    }
}