package fxzou.hard

import fxzou.common.TreeNode
import java.util.*

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
class SerializeAndDeserializeBinaryTree {

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        val queue = LinkedList<TreeNode?>()
        if (root == null) {
            return "null"
        }
        queue.add(root)
        val result = LinkedList<String>()
        while (queue.isNotEmpty()) {
            val node = queue.pop()
            if (node == null) {
                result.add("null")
            } else {
                result.add(node.`val`.toString())
                queue.add(node.left)
                queue.add(node.right)
            }
        }
        return result.joinToString(",")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data == "null") {
            return null
        }
        val list = data.split(",")
        val root = TreeNode(list[0].toInt())
        val preLayerQueue = LinkedList<TreeNode>()
        preLayerQueue.add(root)
        var i = 1
        while (i < list.size) {
            if (i % 2 == 1 && list[i] != "null") {
                val leftNode = TreeNode(list[i].toInt())
                preLayerQueue.first.left = leftNode
                preLayerQueue.add(leftNode)
            }
            if (i % 2 == 0) {
                val parent = preLayerQueue.removeFirst()
                if (list[i] != "null") {
                    val rightNode = TreeNode(list[i].toInt())
                    parent.right = rightNode
                    preLayerQueue.add(rightNode)
                }
            }
            i++
        }
        return root
    }

}