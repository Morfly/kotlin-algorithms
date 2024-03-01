@file:Meta(companies = [Company.Meta], topics = [Topic.Sorting])

package leetcode.`215-kth-largest-element-in-an-array`.`solution-1`

@TimeComplexity("O(n log n)")
@SpaceComplexity("O(1)")
fun findKthLargest(nums: IntArray, k: Int): Int {
    nums.sort()
    return nums[nums.size - k]
}

fun main() {
    val input = intArrayOf(3, 2, 1, 5, 6, 4)

    val result = findKthLargest(input, k = 2)

    println(result)
    require(result == 5)
}