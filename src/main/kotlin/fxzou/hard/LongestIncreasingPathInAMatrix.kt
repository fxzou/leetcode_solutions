package fxzou.hard

/**
 * https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 */
class LongestIncreasingPathInAMatrix {
    companion object {
        val OFFSET = listOf(
            0 to 1,
            0 to -1,
            1 to 0,
            -1 to 0
        )
    }

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        if (matrix.isEmpty()) return 0
        var max = 0
        val cache = Array(matrix.size) { IntArray(matrix[0].size) }
        for (x in matrix.indices) {
            for (y in matrix[x].indices) {
                max = Math.max(max, calculateHelper(matrix, x, y, null, cache))
            }
        }
        return max
    }

    private fun calculateHelper(matrix: Array<IntArray>, x: Int, y: Int, pre: Int?, cache: Array<IntArray>): Int {
        if (x < 0 || x >= matrix.size || y < 0 || y >= matrix[x].size) return 0
        if (pre != null && matrix[x][y] <= pre) return 0
        if (cache[x][y] != 0) return cache[x][y]
        val max = 1 + (OFFSET
            .map { calculateHelper(matrix, x + it.first, y + it.second, matrix[x][y], cache) }
            .max() ?: 0)
        cache[x][y] = max
        return max
    }

}