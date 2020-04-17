package fxzou.medium

/**
 * https://leetcode-cn.com/problems/jump-game/
 */
class JumpGame {

    fun canJump(nums: IntArray): Boolean {
        var left = 0
        var right = 0
        while (right < nums.size - 1) {
            if (right < left) return false
            var newRight = right
            for (i in left..right) {
                newRight = Math.max(newRight, i + nums[i])
            }
            left = right + 1
            right = newRight
        }
        return true
    }

}