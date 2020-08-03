package fxzou.hard

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/
 */
class SmallestRangeCoveringElementsFromKLists {

    fun smallestRange(nums: List<List<Int>>): IntArray {
        val mergedList = mergeAndSortedNums(nums)
        var ans = intArrayOf(mergedList.first().first, mergedList.last().first)
        var left = 0
        var right = 0
        val state = HashMap<Int, Int>()
        state.put(mergedList.first().second, 1)
        while (right < mergedList.size) {
            if (state.size == nums.size) {
                ans = minRange(intArrayOf(mergedList[left].first, mergedList[right].first), ans)
                val key = mergedList[left].second
                state.put(key, state.getValue(key) - 1)
                if (state.getValue(key) == 0) state.remove(key)
                left++
            } else {
                right++
                if (right < mergedList.size) {
                    val key = mergedList[right].second
                    state.put(key, state.getOrDefault(key, 0) + 1)
                }
            }
        }
        return ans
    }

    private fun minRange(range1: IntArray, range2: IntArray): IntArray {
        return if (range1[1] - range1[0] < range2[1] - range2[0]) range1 else range2
    }

    private fun mergeAndSortedNums(nums: List<List<Int>>): ArrayList<Pair<Int, Int>> {
        val size = nums.map { it.size }.sum()
        val priorityQueue = PriorityQueue<Pair<Int, Int>>(size, kotlin.Comparator { o1, o2 -> o1.first - o2.first })
        for (i in nums.indices) {
            for (n in nums[i]) {
                priorityQueue.add(n to i)
            }
        }
        val mergedList = ArrayList<Pair<Int, Int>>(priorityQueue.size)
        while (priorityQueue.isNotEmpty()) {
            mergedList.add(priorityQueue.poll())
        }
        return mergedList
    }

}