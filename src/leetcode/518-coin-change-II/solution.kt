package leetcode.`518-coin-change-II`

// https://leetcode.com/problems/coin-change-ii/
fun change(amount: Int, coins: IntArray): Int {
    val dp = IntArray(amount + 1)
    dp[0] = 1

    for (coin in coins) {
        for (am in coin..amount) {
            if (am - coin >= 0) {
                dp[am] += dp[am - coin]
            }
        }
    }
    return dp[amount]
}

fun main() {
    val coins = intArrayOf(1, 2, 5)

    val result = change(amount = 5, coins)

    println(result)
    require(result == 4)
}