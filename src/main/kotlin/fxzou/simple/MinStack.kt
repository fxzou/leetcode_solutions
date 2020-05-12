package fxzou.simple

import java.util.*

/**
 * https://leetcode-cn.com/problems/min-stack/
 */
class MinStack {
    val linked: LinkedList<Int>
    val minItemStack: LinkedList<Int>

    init {
        linked = LinkedList()
        minItemStack = LinkedList()
        minItemStack.addLast(Int.MAX_VALUE)
    }

    fun push(x: Int) {
        linked.addLast(x)
        minItemStack.addLast(Math.min(x, getMin()))
    }

    fun pop() {
        linked.removeLast()
        minItemStack.removeLast()
    }

    fun top(): Int {
        return linked.last
    }

    fun getMin(): Int {
        return minItemStack.last
    }

}