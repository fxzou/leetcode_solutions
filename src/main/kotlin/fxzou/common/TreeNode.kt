package fxzou.common

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        fun parse(list: List<Int?>): TreeNode {
            val root = TreeNode(list[0]!!)
            val preLayerQueue = LinkedList<TreeNode>()
            preLayerQueue.add(root)
            var i = 1
            while (i < list.size) {
                if (i % 2 == 1 && list[i] != null) {
                    val leftNode = TreeNode(list[i]!!)
                    preLayerQueue.first.left = leftNode
                    preLayerQueue.add(leftNode)
                }
                if (i % 2 == 0) {
                    val parent = preLayerQueue.removeFirst()
                    if (list[i] != null) {
                        val rightNode = TreeNode(list[i]!!)
                        parent.right = rightNode
                        preLayerQueue.add(rightNode)
                    }
                }
                i++
            }
            return root
        }
    }
}