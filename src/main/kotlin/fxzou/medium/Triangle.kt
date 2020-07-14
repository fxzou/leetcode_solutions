package fxzou.medium

/**
 * https://leetcode-cn.com/problems/triangle/
 */
class Triangle {

    //    fun minimumTotal(triangle: List<List<Int>>): Int {
//        val dp = Array(triangle.size) { IntArray(triangle.last().size) }
//        for (x in triangle.indices.reversed()) {
//            for (y in triangle[x].indices) {
//                if (x == triangle.size - 1) {
//                    dp[x][y] = triangle[x][y]
//                    continue
//                }
//                dp[x][y] = triangle[x][y] + Math.min(dp[x + 1][y], dp[x + 1][y + 1])
//            }
//        }
//        return dp[0][0]
//    }
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val dp = IntArray(triangle.size)
        for (x in triangle.indices.reversed()) {
            for (y in 0..x) {
                if (x == triangle.size - 1) {
                    dp[y] = triangle[x][y]
                    continue
                }
                dp[y] = triangle[x][y] + Math.min(dp[y], dp[y + 1])
            }
        }
        return dp[0]
    }
}