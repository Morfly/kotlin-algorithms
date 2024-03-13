@file:Problem(companies = [Company.Meta], topics = [Topic.Array, Topic.TwoPointers, Topic.Sorting])

package leetcode.`15-3sum`

@TimeComplexity("O(n^2)")
@SpaceComplexity("O(n)")
fun threeSum(nums: IntArray): List<List<Int>> {
    val result = arrayListOf<List<Int>>()
    nums.sort()

    for (i in 0..<nums.lastIndex) {
        if (i == 0 || nums[i] != nums[i - 1]) {
            val target = 0 - nums[i]

            var start = i + 1
            var end = nums.lastIndex
            while (start < end) {
                when {
                    nums[start] + nums[end] == target -> {
                        result += listOf(nums[i], nums[start], nums[end])
                        while (start < end && nums[start] == nums[start + 1]) start++
                        while (start < end && nums[end] == nums[end - 1]) end--
                        start++
                        end--
                    }

                    nums[start] + nums[end] > target -> end--
                    else -> start++
                }
            }
        }
    }
    return result
}

fun main() {
    val input = intArrayOf(-1, 0, 1, 2, -1, -4)

    val result = threeSum(input)

    println(result)
    require(result == listOf(listOf(-1, 0, 1), listOf(-1, -1, 2)))
}