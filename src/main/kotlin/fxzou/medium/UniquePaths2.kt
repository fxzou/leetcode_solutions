package fxzou.medium

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
class UniquePaths2 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val ans = Array(obstacleGrid.size) { IntArray(obstacleGrid[0].size) }
        ans[0][0] = if (obstacleGrid[0][0] == 1) 0 else 1
        for (x in obstacleGrid.indices) {
            for (y in obstacleGrid[x].indices) {
                if (x == 0 && y == 0) continue
                ans[x][y] = 0
                if (obstacleGrid[x][y] == 1) continue
                if (x > 0) ans[x][y] += ans[x - 1][y]
                if (y > 0) ans[x][y] += ans[x][y - 1]
            }
        }
        return ans.last().last()
    }
}