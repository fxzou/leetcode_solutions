package fxzou.medium

import fxzou.common.TreeNode
import java.util.*

class BinaryTreeRightSideView {

    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val ans = LinkedList<Int>()
        helper(root, 0, ans)
        return ans
    }

    private fun helper(node: TreeNode, vDepth: Int, ans: MutableList<Int>) {
        if (vDepth >= ans.size) {
            ans.add(node.`val`)
        }
        node.right?.let { helper(it, vDepth + 1, ans) }
        node.left?.let { helper(it, vDepth + 1, ans) }
    }

}