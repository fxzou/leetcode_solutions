package fxzou.simple

/**
 * https://leetcode-cn.com/problems/single-number/
 */
class SingleNumber {

    fun singleNumber(nums: IntArray): Int {
        return nums.reduce { acc, n -> acc xor n }
    }

}