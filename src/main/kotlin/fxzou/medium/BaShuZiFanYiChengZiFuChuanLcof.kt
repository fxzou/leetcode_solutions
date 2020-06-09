package fxzou.medium

import java.util.*

/**
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
class BaShuZiFanYiChengZiFuChuanLcof {
    fun translateNum(num: Int): Int {
        val bitArray = numToBitArray(num)
        var ans1 = 1
        var ans2 = 1
        for (i in 1..bitArray.size - 1) {
            val ans = if (bitArray[i - 1] > 0 && bitArray[i - 1] * 10 + bitArray[i] < 26) ans1 + ans2 else ans2
            ans1 = ans2
            ans2 = ans
        }
        return ans2
    }

    private fun numToBitArray(num: Int): List<Int> {
        if (num == 0) {
            return listOf(0)
        }
        val result = LinkedList<Int>()
        var temp = num
        while (temp != 0) {
            result.addFirst(temp % 10)
            temp /= 10
        }
        return result.toList()
    }
}