package fxzou.medium

import fxzou.common.TreeNode
import java.util.*

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
class LowestCommonAncestorOfABinaryTree {
    private var findFirst = false
    private var find = false
    private val firstNodeAncestorStack = LinkedList<TreeNode>()
    private lateinit var nodes: Set<TreeNode>

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode {
        nodes = setOf(p!!, q!!)
        findHelper(root!!)
        return firstNodeAncestorStack.last
    }

    private fun findHelper(current: TreeNode) {
        if (find) return
        if (!findFirst) firstNodeAncestorStack.add(current)
        if (nodes.contains(current)) {
            if (findFirst) {
                find = true
            } else {
                findFirst = true
            }
        }
        if (current.left != null) findHelper(current.left!!)
        if (current.right != null) findHelper(current.right!!)
        if (!find && firstNodeAncestorStack.last == current) firstNodeAncestorStack.removeLast()
    }

}