package fxzou.medium

/**
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/
 * 思路：由外到内，逐步旋转每一个正方形
 */
class RotateMatrix {

    fun rotate(matrix: Array<IntArray>) {
        if (matrix.isEmpty()) {
            return
        }
        var depth = 0
        var lenOfSide = matrix.size
        while (lenOfSide > 1) {
            for (offset in 0..lenOfSide - 2) {
                val maxIndex = depth + lenOfSide - 1
                val temp = matrix[depth][depth + offset]
                matrix[depth][depth + offset] = matrix[maxIndex - offset][depth]
                matrix[maxIndex - offset][depth] = matrix[maxIndex][maxIndex - offset]
                matrix[maxIndex][maxIndex - offset] = matrix[depth + offset][maxIndex]
                matrix[depth + offset][maxIndex] = temp
            }
            depth++
            lenOfSide -= 2
        }
    }

}