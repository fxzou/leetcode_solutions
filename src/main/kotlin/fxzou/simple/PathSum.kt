package fxzou.simple

import fxzou.common.TreeNode

/**
 * https://leetcode-cn.com/problems/path-sum/
 */
class PathSum {

    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        return helper(root, 0, sum)
    }

    fun helper(node: TreeNode?, sum: Int, target: Int): Boolean {
        if (node == null) return false
        val s = sum + node.`val`
        if (s == target && node.left == null && node.right == null) return true
        return helper(node.left, s, target) || helper(node.right, s, target)
    }

}