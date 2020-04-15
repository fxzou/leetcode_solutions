package fxzou.medium

/**
 * https://leetcode-cn.com/problems/01-matrix/
 */
class Matrix01 {

    companion object {
        val offsets = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0)
        )
    }

    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        for (x in matrix.indices) {
            for (y in matrix[x].indices) {
                val brDistance = calculateBottomRightDistanceTo0(matrix, x, y)
                var minDistance = brDistance
                if (x > 0) {
                    minDistance = Math.min(minDistance, matrix[x - 1][y] + 1)
                }
                if (y > 0) {
                    minDistance = Math.min(minDistance, matrix[x][y - 1] + 1)
                }
                matrix[x][y] = minDistance
            }
        }
        for (x in matrix.indices) {
            for (y in matrix[x].indices) {
                matrix[x][y] -= 2
            }
        }
        return matrix
    }

    // 计算该点到右下角的0的最小距离
    private fun calculateBottomRightDistanceTo0(matrix: Array<IntArray>, x: Int, y: Int): Int {
        if (x < 0 || x >= matrix.size || y < 0 || y >= matrix[0].size) {
            return Int.MAX_VALUE
        }
        if (matrix[x][y] > 1) {
            return matrix[x][y]
        }
        // offset 2 to make the point was calculated
        var distance = 2
        if (matrix[x][y] != 0) {
            distance = offsets.map { calculateBottomRightDistanceTo0(matrix, x + it[0], y + it[1]) }
                .filter { it < Int.MAX_VALUE }
                .min()?.let { it + 1 } ?: Int.MAX_VALUE
        }
        matrix[x][y] = distance
        return distance
    }
}