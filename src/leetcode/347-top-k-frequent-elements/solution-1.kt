@file:Problem(companies = [Company.Meta], topics = [Topic.Heap, Topic.Sorting])

package leetcode.`347-top-k-frequent-elements`.`solution-1`

import java.util.PriorityQueue

@TimeComplexity("O(n log k)")
@SpaceComplexity("O(n)")
fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (num in nums) {
        map[num] = map.getOrDefault(num, 0) + 1
    }

    val queue = PriorityQueue<Int>(k, compareBy { map[it] })
    for ((num, _) in map) {
        queue += num
        if (queue.size > k) {
            queue.remove()
        }
    }
    val result = IntArray(k) { queue.remove() }
    result.reverse()
    return result
}

fun main() {
    val nums = intArrayOf(1, 1, 1, 2, 2, 3)

    val result = topKFrequent(nums, k = 2).toList()

    println(result)
    require(result == listOf(1, 2))
}