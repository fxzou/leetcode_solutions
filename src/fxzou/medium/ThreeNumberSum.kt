package fxzou.medium

import java.util.*
import java.util.Collections.binarySearch

/**
 * https://leetcode-cn.com/problems/3sum/
 */

class ThreeNumberSum {

    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return listOf()
        }
        val positiveNumbers: MutableList<Int> = ArrayList(nums.size)
        val negativeNumbers: MutableList<Int> = ArrayList(nums.size)
        var zeroCount = 0
        var maxPositiveNumber = 0
        var minNegativeNumber = 0
        for (num in nums) {
            if (num > 0) {
                positiveNumbers.add(num)
                if (num > maxPositiveNumber) {
                    maxPositiveNumber = num
                }
            }
            if (num < 0) {
                negativeNumbers.add(num)
                if (num < minNegativeNumber) {
                    minNegativeNumber = num
                }
            }
            if (num == 0) {
                zeroCount++
            }
        }
        val result: MutableList<List<Int>> = ArrayList()
        if (zeroCount > 2) {
            result.add(listOf(0, 0, 0))
        }
        Collections.sort(positiveNumbers)
        Collections.sort(negativeNumbers)
        for (nIndex in negativeNumbers.indices) {
            for (pIndex in positiveNumbers.indices) {
                val towSum = negativeNumbers[nIndex] + positiveNumbers[pIndex]
                if (-towSum > maxPositiveNumber || towSum < minNegativeNumber) {
                    continue
                }
                if (towSum == 0 && zeroCount > 0) {
                    result.add(listOf(negativeNumbers[nIndex], 0, positiveNumbers[pIndex]))
                    continue
                }
                val threeIndex =
                    if (towSum > 0) binarySearch(negativeNumbers, -towSum) else binarySearch(positiveNumbers, -towSum)
                if (threeIndex >= 0) {
                    val isCurrentIndex = if (towSum > 0) threeIndex == nIndex else threeIndex == pIndex
                    if (!isCurrentIndex) result.add(listOf(negativeNumbers[nIndex], positiveNumbers[pIndex], -towSum))
                }
            }
        }
        return result.distinctBy { it.sorted().toString() }
    }


}