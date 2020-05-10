package fxzou.simple

/**
 * https://leetcode-cn.com/problems/sqrtx/
 */
class Sqrtx {
    fun mySqrt(x: Int): Int {
        if (x == 0) return 0
        var left = 1
        var right = x
        while (left < right) {
            val middle = left + (right - left) / 2
            if (x / middle == middle) {
                return middle
            } else if (x / middle < middle) {
                right = middle - 1
            } else {
                left = middle + 1
            }
        }
        return if (left * left <= x) left else left - 1
    }
}