package fxzou.medium

import java.util.*

/**
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 */
class CountNumberOfNiceSubarrays {

    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        var count = 0
        val oddIndexQueue = LinkedList<Int>()
        oddIndexQueue.add(-1)
        for (i in 0..nums.size) {
            if (i == nums.size || nums[i] % 2 == 1) {
                oddIndexQueue.add(i)
            }
            if (oddIndexQueue.size < k + 2) {
                continue
            }
            // 此时队列中包含k个奇数index + 2个边界index
            count += (oddIndexQueue[1] - oddIndexQueue.first) * (oddIndexQueue.last - oddIndexQueue[k])
            oddIndexQueue.removeFirst()
        }
        return count
    }

}