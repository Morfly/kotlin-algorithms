@file:Problem(companies = [Company.Meta], topics = [Topic.Array])

package leetcode.`918-maximum-sum-circular-subarray`

@TimeComplexity("O(n)")
@SpaceComplexity("O(1)")
fun maxSubarraySumCircular(nums: IntArray): Int {
    var totalSum = 0
    var currMinSum = 0
    var currMaxSum = 0
    var minSum = Int.MAX_VALUE
    var maxSum = Int.MIN_VALUE

    for (num in nums) {
        totalSum += num
        currMinSum = minOf(currMinSum + num, num)
        currMaxSum = maxOf(currMaxSum + num, num)
        minSum = minOf(minSum, currMinSum)
        maxSum = maxOf(maxSum, currMaxSum)
    }

    return if (maxSum < 0) {
        maxSum
    } else {
        maxOf(maxSum, totalSum - minSum)
    }
}

fun main() {
    val input = intArrayOf(5, -3, 5)

    val result = maxSubarraySumCircular(input)

    println(result)
    require(result == 10)
}