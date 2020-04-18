package fxzou.medium

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
class ContainerWithMostWater {

    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size - 1
        var maxArea = 0
        while (left < right) {
            val leftHeight = heights[left]
            val rightHeight = heights[right]
            val area = Math.min(leftHeight, rightHeight) * (right - left)
            maxArea = Math.max(maxArea, area)
            if (leftHeight <= rightHeight) {
                left = (left + 1..right).find { heights[it] > leftHeight } ?: right
            }
            if (rightHeight <= leftHeight) {
                right = (right - 1 downTo left).find { heights[it] > rightHeight } ?: left
            }
        }
        return maxArea
    }
}