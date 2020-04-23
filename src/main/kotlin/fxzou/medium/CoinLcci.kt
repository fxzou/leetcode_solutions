package fxzou.medium

/**
 * https://leetcode-cn.com/problems/coin-lcci/
 */
class CoinLcci {

    fun waysToChange(n: Int): Int {
        val dp = IntArray(n + 1)
        val coins = intArrayOf(1, 5, 10, 25)
        dp[0] = 1

        for (coin in coins) {
            for (i in coin..n) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007
            }
        }

        return dp[n]
    }

}