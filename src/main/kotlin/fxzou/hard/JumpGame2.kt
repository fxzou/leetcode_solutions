package fxzou.hard

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 */

class JumpGame2 {

    fun jump(nums: IntArray): Int {
        return calculateMinStepsStartWithCurrentIndex(nums, 0, IntArray(nums.size))
    }

    fun calculateMinStepsStartWithCurrentIndex(nums: IntArray, currIndex: Int, cache: IntArray): Int {
        if (currIndex == nums.size - 1) {
            return 0
        }
        if (cache[currIndex] != 0) {
            return cache[currIndex]
        }
        var minSteps = Int.MAX_VALUE - 1
        for (i in 1..nums[currIndex]) {
            if (currIndex + i == nums.size) break
            val steps = calculateMinStepsStartWithCurrentIndex(nums, currIndex + i, cache) + 1
            if (steps < minSteps) {
                minSteps = steps
            }
        }
        cache[currIndex] = minSteps
        return minSteps
    }
}