package fxzou.medium

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
class MinimumPathSum {

    fun minPathSum(grid: Array<IntArray>): Int {
        val dp = Array(grid.size) { IntArray(grid[0].size) }
        for (x in dp.indices) {
            for (y in dp[x].indices) {
                if (x == 0 && y == 0) {
                    dp[x][y] = grid[x][y]
                    continue
                }
                val top = if (x > 0) dp[x - 1][y] else Int.MAX_VALUE
                val left = if (y > 0) dp[x][y - 1] else Int.MAX_VALUE
                dp[x][y] = grid[x][y] + Math.min(top, left)
            }
        }
        return dp.last().last()
    }

}