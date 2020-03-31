package fxzou.medium

import java.util.*

/**
 * https://leetcode-cn.com/problems/ambiguous-coordinates/
 */

class AmbiguousCoordinates {

    fun ambiguousCoordinates(str: String): List<String> {
        val numbers = str.substring(1, str.length - 1).toCharArray().map { it.toString().toInt() }
        val result: MutableList<String> = LinkedList()
        for (i in 0..numbers.size - 2) {
            if (valid(numbers, 0, i) && valid(numbers, i + 1, numbers.size - 1)) {
                val left = helper(numbers, 0, i)
                val right = helper(numbers, i + 1, numbers.size - 1)
                for (l in left) {
                    for (r in right) {
                        result.add("(" + l + ", " + r + ")")
                    }
                }
            }
        }
        return result
    }

    fun helper(numbers: List<Int>, startIndex: Int, endIndex: Int): List<String> {
        if (startIndex == endIndex) {
            return listOf(numbers[startIndex].toString())
        }
        if (numbers[startIndex] == 0) {
            return listOf("0." + toString(numbers, startIndex + 1, endIndex))
        }
        if (numbers[endIndex] == 0) {
            return listOf(toString(numbers, startIndex, endIndex))
        }
        val result: MutableList<String> = LinkedList()
        for (i in startIndex..endIndex) {
            result.add(
                toString(numbers, startIndex, i) + if (i == endIndex) "" else "." + toString(
                    numbers,
                    i + 1,
                    endIndex
                )
            )
        }
        return result

    }

    fun valid(numbers: List<Int>, startIndex: Int, endIndex: Int): Boolean =
        startIndex == endIndex || numbers[startIndex] != 0 || numbers[endIndex] != 0

    fun toString(numbers: List<Int>, startIndex: Int, endIndex: Int): String {
        return numbers.subList(startIndex, endIndex + 1).joinToString(separator = "")
    }


}