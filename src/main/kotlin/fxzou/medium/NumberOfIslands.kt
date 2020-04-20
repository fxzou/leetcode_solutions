package fxzou.medium

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 */
class NumberOfIslands {

    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        for (x in grid.indices) {
            for (y in grid[x].indices) {
                if (grid[x][y] == '1') {
                    count++
                    expansion(grid, x, y)
                }
            }
        }
        return count
    }

    fun expansion(grid: Array<CharArray>, x: Int, y: Int) {
        if (x < 0 || x >= grid.size || y < 0 || y >= grid[x].size) {
            return
        }
        if (grid[x][y] == '0' || grid[x][y] == '2') {
            return
        }
        grid[x][y] = '2'
        expansion(grid, x - 1, y)
        expansion(grid, x + 1, y)
        expansion(grid, x, y - 1)
        expansion(grid, x, y + 1)
    }

}