package leetcode.`320-coin-change`

import kotlin.math.min

// https://leetcode.com/problems/coin-change/description/
// https://www.youtube.com/watch?v=H9bfqozjoqs&t=908s
fun coinChange(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { amount + 1 }
    dp[0] = 0

    for (am in 1..amount) {
        for (coin in coins) {
            if (am - coin >= 0) {
                dp[am] = min(dp[am], 1 + dp[am - coin])
            }
        }
    }
    return if (dp[amount] != amount + 1) dp[amount] else -1
}

fun main() {
    val coins = intArrayOf(1, 3, 4, 5)

    val result = coinChange(coins, amount = 7)

    println(result)
    require(result == 2)
}