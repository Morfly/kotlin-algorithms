@file:Problem(topics = [Topic.DynamicProgramming, Topic.Array])

package leetcode.`121-best-time-to-buy-and-sell-stock`

@TimeComplexity("O(n)")
@SpaceComplexity("O(1)")
fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0

    var min = 0
    for (curr in prices.indices) {
        if (prices[curr] < prices[min]) {
            min = curr
        } else {
            val profit = prices[curr] - prices[min]
            maxProfit = maxOf(profit, maxProfit)
        }
    }

    return maxProfit
}

fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)

    val result = maxProfit(prices)

    println(result)
    require(result == 5)
}