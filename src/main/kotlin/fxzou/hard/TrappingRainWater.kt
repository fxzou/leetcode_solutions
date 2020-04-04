package fxzou.hard

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */

class TrappingRainWater {
    fun trap(height: IntArray): Int {
        if (height.isEmpty()) {
            return 0
        }
        var result = 0
        var currentLeftBoardIndex = 0
        while (currentLeftBoardIndex < height.size - 1) {
            var rightBoardIndex = currentLeftBoardIndex + 1
            var maxHeightOfRange = -1
            for (i in rightBoardIndex..height.size - 1) {
                if (height[i] >= height[currentLeftBoardIndex]) {
                    rightBoardIndex = i
                    break
                }
                if (height[i] >= maxHeightOfRange) {
                    rightBoardIndex = i
                    maxHeightOfRange = height[i]
                }
            }
            result += calculateValidSpaceInRange(height, currentLeftBoardIndex, rightBoardIndex)
            currentLeftBoardIndex = rightBoardIndex
        }
        return result
    }

    private fun calculateValidSpaceInRange(height: IntArray, startIndex: Int, endIndex: Int): Int {
        if (endIndex - startIndex < 2) {
            return 0
        }
        val blockCountInRange = (startIndex + 1..endIndex - 1).sumBy { height[it] }
        val validHeight = Math.min(height[startIndex], height[endIndex])
        return validHeight * (endIndex - startIndex - 1) - blockCountInRange
    }
}