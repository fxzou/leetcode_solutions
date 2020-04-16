package fxzou.medium

import java.util.*

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 */
class MergeIntervals {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val result = LinkedList<IntArray>()
        for (interval in intervals) {
            val last = if (result.isNotEmpty()) result.last else null
            if (last == null || last[1] < interval[0]) {
                result.add(interval)
                continue
            }
            result.removeLast()
            result.add(intArrayOf(Math.min(last[0], interval[0]), Math.max(last[1], interval[1])))
        }
        val resultArray = Array(result.size) { intArrayOf() }
        return result.toArray(resultArray)
    }

}