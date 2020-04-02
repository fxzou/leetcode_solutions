package fxzou.medium

/**
 * https://leetcode-cn.com/problems/game-of-life/
 */

class GameOfLife {

    fun gameOfLife(board: Array<IntArray>) {
        val aroundOffsets = arrayOf(
            intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1),
            intArrayOf(0, -1), /*     center    */intArrayOf(0, 1),
            intArrayOf(1, -1), intArrayOf(1, 0), intArrayOf(1, 1)
        )
        val rowSize = board.size
        val colSize = if (rowSize > 0) board[0].size else 0

        for (rowIndex in board.indices) {
            for (colIndex in board[rowIndex].indices) {
                val aroundLiveSize = aroundOffsets
                    .filter { (rowIndex + it[0]) in 0..rowSize - 1 && (colIndex + it[1]) in 0..colSize - 1 }
                    .map { if (board[rowIndex + it[0]][colIndex + it[1]] in intArrayOf(-1, 1)) 1 else 0 }
                    .sum()
                when {
                    board[rowIndex][colIndex] == 1 && aroundLiveSize < 2 -> board[rowIndex][colIndex] = -1
                    board[rowIndex][colIndex] == 1 && aroundLiveSize > 3 -> board[rowIndex][colIndex] = -1
                    board[rowIndex][colIndex] == 0 && aroundLiveSize == 3 -> board[rowIndex][colIndex] = 2
                }
            }
        }
        for (rowIndex in board.indices) {
            for (colIndex in board[rowIndex].indices) {
                board[rowIndex][colIndex] = if (board[rowIndex][colIndex] > 0) 1 else 0
            }
        }
    }

}