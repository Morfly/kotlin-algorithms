@file:Meta(companies = [Company.Meta], topics = [Topic.Sorting, Topic.BucketSort])

package leetcode.`347-top-k-frequent-elements`.`solution-2`

@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    val freq = Array(nums.size + 1) { mutableListOf<Int>() }

    for (num in nums) {
        map[num] = map.getOrDefault(num, 0) + 1
    }
    for ((num, count) in map) {
        freq[count] += num
    }

    val result = mutableListOf<Int>()
    for (i in freq.lastIndex downTo 0) {
        for (num in freq[i]) {
            result += num
            if (result.size == k) return result.toIntArray()
        }
    }
    return intArrayOf()
}

fun main() {
    val nums = intArrayOf(1, 1, 1, 2, 2, 3)

    val result = topKFrequent(nums, k = 2).toList()

    println(result)
    require(result == listOf(1, 2))
}
