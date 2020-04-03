package fxzou.medium

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */

class StringToIntegerAtoi {

    fun myAtoi(str: String): Int {
        if (str.isBlank()) {
            return 0
        }
        var startParse = false
        var sign = 1
        var result = 0
        loop@ for (c in str) {
            when {
                c == ' ' && !startParse -> continue@loop
                c == '-' && !startParse -> {
                    sign = -1
                    startParse = true
                }
                c == '+' && !startParse -> {
                    sign = 1
                    startParse = true
                }
                !c.isNumber() -> break@loop
                c.isNumber() && !startParse -> {
                    startParse = true
                    result = c.toNumber()
                }
                else -> {
                    val limit = if (sign == 1) (Int.MAX_VALUE - c.toNumber()) / 10 else -((Int.MIN_VALUE + c.toNumber()) / 10)
                    if (result > limit) {
                        return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
                    }
                    result = result * 10 + c.toNumber()
                }
            }
        }

        return result * sign
    }

    private fun Char.isNumber() = this.toInt() in '0'.toInt()..'9'.toInt()
    private fun Char.toNumber() = this.toInt() - '0'.toInt()


}