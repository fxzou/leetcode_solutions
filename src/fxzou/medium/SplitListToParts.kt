package fxzou.medium

import java.util.*

/**
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/
 */
class SplitListToParts {
    fun splitListToParts(root: ListNode?, k: Int): Array<ListNode?> {
        val size = size(root)
        val baseline = size / k
        val moreItemSize = size - baseline * k
        val result = Array<ListNode?>(k, { null })
        var nextNode: ListNode? = root
        for (i in 0..k - 1) {
            if (nextNode == null) {
                break
            }
            val itemSize = if (i < moreItemSize) baseline + 1 else baseline
            val (split, newHeader) = splitHeader(nextNode, itemSize)
            result[i] = split
            nextNode = newHeader
        }
        return result
    }

    private fun splitHeader(header: ListNode, size: Int): Pair<ListNode, ListNode?> {
        var nextNode: ListNode? = header
        var splitPoint: ListNode = header
        for (i in 1..size) {
            if (nextNode == null) {
                break
            }
            splitPoint = nextNode
            nextNode = nextNode.next
        }
        val newHeader = splitPoint.next
        splitPoint.next = null
        return Pair(header, newHeader)
    }

    private fun size(root: ListNode?): Int {
        var count = 0
        var nextNode: ListNode? = root
        while (nextNode != null) {
            nextNode = nextNode.next
            count++
        }
        return count
    }
}

data class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return `val`.toString() + if (next != null) "->" + next.toString() else ""
    }
}

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val root = ListNode(1)
        var nextNode: ListNode = root
        for (i in 2..15) {
            val next = ListNode(i)
            nextNode.next = next
            nextNode = next
        }
        println(root)
        println(Arrays.toString(SplitListToParts().splitListToParts(root, 7)))
    }
}