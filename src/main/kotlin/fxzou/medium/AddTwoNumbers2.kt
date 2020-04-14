package fxzou.medium

import java.util.*

/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
class AddTwoNumbers2 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
        override fun toString(): String {
            return "${`val`}${if (next != null) next.toString() else ""}"
        }
    }

    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
        var resultHeader: ListNode? = null
        val stack1 = pushInStack(l1)
        val stack2 = pushInStack(l2)
        var overflow = false
        while (stack1.isNotEmpty() || stack2.isNotEmpty()) {
            val bit1 = if (stack1.isNotEmpty()) stack1.pop() else 0
            val bit2 = if (stack2.isNotEmpty()) stack2.pop() else 0
            val bitSum = bit1 + bit2 + if (overflow) 1 else 0
            overflow = bitSum > 9
            resultHeader = insertToFirst(resultHeader, ListNode(bitSum % 10))
        }
        if (overflow) {
            resultHeader = insertToFirst(resultHeader, ListNode(1))
        }
        return resultHeader!!
    }

    private fun insertToFirst(nowHeader: ListNode?, newHeader: ListNode): ListNode {
        newHeader.next = nowHeader
        return newHeader
    }

    private fun pushInStack(list: ListNode): Stack<Int> {
        val stack = Stack<Int>()
        var next: ListNode? = list
        while (next != null) {
            stack.push(next.`val`)
            next = next.next
        }
        return stack
    }
}

