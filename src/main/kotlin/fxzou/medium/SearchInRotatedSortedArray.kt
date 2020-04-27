package fxzou.medium

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
class SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        var leftIndex = 0
        var rightInt = nums.size - 1
        while (leftIndex <= rightInt) {
            val isSortedRange = nums[leftIndex] < nums[rightInt]
            if (isSortedRange && (target < nums[leftIndex] || target > nums[rightInt])) return -1
            val middle = leftIndex + (rightInt - leftIndex) / 2
            if (nums[middle] == target) return middle
            if (target > nums[middle]) {
                if (nums[leftIndex] > nums[middle] && nums[leftIndex] <= target) {
                    rightInt = middle - 1
                } else {
                    leftIndex = middle + 1
                }
            } else {
                if (nums[rightInt] < nums[middle] && nums[rightInt] >= target) {
                    leftIndex = middle + 1
                } else {
                    rightInt = middle - 1
                }
            }
        }
        return -1
    }
}