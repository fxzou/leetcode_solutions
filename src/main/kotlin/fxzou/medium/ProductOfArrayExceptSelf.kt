package fxzou.medium

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 */
class ProductOfArrayExceptSelf {

    fun productExceptSelf(nums: IntArray): IntArray {
        if (nums.isEmpty()) {
            return IntArray(0)
        }
        val out = IntArray(nums.size)
        out[0] = 1
        var lastProduct = nums[0]
        for (i in 1..nums.size - 1) {
            out[i] = lastProduct
            lastProduct *= nums[i]
        }
        lastProduct = nums[nums.size - 1]
        for (i in nums.size - 2 downTo 0) {
            out[i] *= lastProduct
            lastProduct *= nums[i]
        }
        return out
    }
}