@file:Problem(companies = [Company.Meta], topics = [Topic.Array, Topic.PrefixSum, Topic.HashTable])

package leetcode.`560-subarray-sum-equals-k`

@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
fun subarraySum(nums: IntArray, k: Int): Int {
    if (nums.isEmpty()) return 0

    var counter = 0
    val dict = mutableMapOf(0 to 1)

    var sum = 0
    for (num in nums) {
        sum += num
        val diff = sum - k

        counter += dict.getOrDefault(diff, 0)
        dict[sum] = dict.getOrDefault(sum, 0) + 1
    }

    return counter
}

fun main() {
    val input = intArrayOf(1, -1, 0)

    val result = subarraySum(input, k = 0)

    println(result)
    require(result == 3)
}