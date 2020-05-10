package fxzou.medium

/**
 * https://leetcode-cn.com/problems/maximal-square/
 */
class MaximalSquare {

    fun maximalSquare(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty()) {
            return 0
        }
        var maxSide = 0
        val cache = Array(matrix.size) { IntArray(matrix[0].size) }
        for (i in matrix.indices) {
            cache[i][0] = if (matrix[i][0] == '1') 1 else 0
            maxSide = Math.max(maxSide, cache[i][0])
        }
        for (i in matrix[0].indices) {
            cache[0][i] = if (matrix[0][i] == '1') 1 else 0
            maxSide = Math.max(maxSide, cache[0][i])
        }
        for (x in 1..matrix.size - 1) {
            for (y in 1..matrix[x].size - 1) {
                if (matrix[x][y] == '1') {
                    var preSide = 0
                    for (offset in 1..cache[x - 1][y - 1]) {
                        if (matrix[x - offset][y] == '1' && matrix[x][y - offset] == '1') {
                            preSide += 1
                        } else {
                            break
                        }
                    }
                    cache[x][y] = 1 + preSide
                    maxSide = Math.max(maxSide, cache[x][y])
                } else {
                    cache[x][y] = 0
                }
            }
        }
        return maxSide * maxSide
    }

}