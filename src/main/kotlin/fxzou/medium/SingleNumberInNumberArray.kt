package fxzou.medium

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
class SingleNumberInNumberArray {

    fun singleNumbers(nums: IntArray): IntArray {
        val xorResult = nums.reduce { acc, i -> acc xor i }
        var diffBit = 1
        while (xorResult and diffBit == 0) diffBit = diffBit shl 1
        var a = 0
        var b = 0
        for (num in nums) {
            if (diffBit and num == 0) {
                a = a xor num
            } else {
                b = b xor num
            }
        }
        return intArrayOf(a, b)
    }
}