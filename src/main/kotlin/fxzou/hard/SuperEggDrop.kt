package fxzou.hard

class SuperEggDrop {
    lateinit var cache: Array<IntArray>

    fun superEggDrop(k: Int, n: Int): Int {
        cache = Array(k + 1) { IntArray(n + 1) }
        for (i in 1..n) cache[1][i] = i
        for (i in 1..k) cache[i][1] = 1
        for (i in 2..k) {
            for (j in 2..n) {
//                timeout
//                cache[i][j] = (1..j).map { 1 + Math.max(cache[i - 1][it - 1], cache[i][j - it]) }.min() ?: 0
                var left = 1
                var right = j
                while (left + 1 < right) {
                    val middle = left + (right - left) / 2
                    when {
                        cache[i - 1][middle - 1] < cache[i][j - middle] -> left = middle
                        cache[i - 1][middle - 1] > cache[i][j - middle] -> right = middle
                        cache[i - 1][middle - 1] == cache[i][j - middle] -> {
                            left = middle
                            right = middle
                        }
                    }
                }
                cache[i][j] = 1 + Math.min(
                    Math.max(cache[i - 1][left - 1], cache[i][j - left]),
                    Math.max(cache[i - 1][right - 1], cache[i][j - right])
                )
            }
        }
        return cache[k][n]
    }


}