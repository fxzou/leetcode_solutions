package fxzou.medium

/**
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
class IntegerToRoman {

    companion object {
        val intMapToRoman = linkedMapOf(
            1000 to "M",
            900 to "CM",
            500 to "D",
            400 to "CD",
            100 to "C",
            90 to "XC",
            50 to "L",
            40 to "XL",
            10 to "X",
            9 to "IX",
            5 to "V",
            4 to "IV",
            1 to "I"
        )
    }

    fun intToRoman(num: Int): String {
        var result = ""
        var remain = num
        while (remain > 0) {
            val (n, roman) = intMapToRoman
                .entries
                .filter { remain >= it.key }
                .first()
            val repeatCount = remain / n
            result += roman.repeat(repeatCount)
            remain -= n * repeatCount
        }

        return result
    }
}