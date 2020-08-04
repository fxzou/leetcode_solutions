package fxzou.medium

import java.util.*
import kotlin.collections.HashMap

/**
 * https://leetcode-cn.com/problems/course-schedule/
 */
class CourseSchedule {

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val state = IntArray(numCourses)
        val graph = HashMap<Int, LinkedList<Int>>()
        for (p in prerequisites) {
            if (!graph.containsKey(p[0])) {
                graph.put(p[0], LinkedList())
            }
            graph.getValue(p[0]).add(p[1])
        }
        return state.indices.all { helper(it, graph, state) }
    }

    private fun helper(current: Int, graph: HashMap<Int, LinkedList<Int>>, state: IntArray): Boolean {
        if (state[current] == 1) return true
        if (state[current] == -1) return false
        state[current] = -1
        if (!graph.containsKey(current)) {
            state[current] = 1
            return true
        }
        val canFinish = graph.getValue(current).all { helper(it, graph, state) }
        if (canFinish) state[current] = 1
        return canFinish
    }
}