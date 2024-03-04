@file:Problem(companies = [Company.Meta], topics = [Topic.PrefixSum])

package leetcode.`523-continuous-subarray-sum`

@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
    val remainders = mutableMapOf(0 to -1)

    var sum = 0
    for ((i, num) in nums.withIndex()) {
        sum += num
        val rem = sum % k

        if (rem !in remainders) {
            remainders[rem] = i
        } else if (i - remainders[rem]!! >= 2) {
            return true
        }
    }
    return false
}

fun main() {
    val input = intArrayOf(23, 2, 4, 6, 7)

    val result = checkSubarraySum(input, k = 6)

    println(result)
    require(result)
}