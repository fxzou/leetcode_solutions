package fxzou.medium

import fxzou.common.TreeNode

class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return validateHelper(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun validateHelper(root: TreeNode, min: Long, max: Long): Boolean {
        var result = true
        if (root.left != null) {
            val leftValue = root.left!!.`val`
            result = leftValue > min && leftValue < root.`val` && validateHelper(root.left!!, min, root.`val`.toLong())
        }
        if (result && root.right != null) {
            val rightValue = root.right!!.`val`
            result =
                rightValue > root.`val` && rightValue < max && validateHelper(root.right!!, root.`val`.toLong(), max)
        }
        return result
    }
}