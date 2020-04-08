package fxzou.medium

class RobotRangeOfMotion {

    fun movingCount(m: Int, n: Int, k: Int): Int {
        val map = Array(m) { IntArray(n) }
        return helper(0, 0, k, map)
    }

    private fun helper(x: Int, y: Int, k: Int, map: Array<IntArray>): Int {
        if (x < 0 || x >= map.size || y < 0 || y >= map[0].size) return 0
        if (map[x][y] != 0) return 0
        map[x][y] = 1
        if ((bitSum(x) + bitSum(y)) > k) return 0
        return (
                1
                        + helper(x - 1, y, k, map)
                        + helper(x + 1, y, k, map)
                        + helper(x, y - 1, k, map)
                        + helper(x, y + 1, k, map)
                )
    }

    private fun bitSum(num: Int): Int {
        var sum = 0
        var remain = num
        while (remain > 0) {
            sum += remain % 10
            remain = remain / 10
        }
        return sum
    }

}