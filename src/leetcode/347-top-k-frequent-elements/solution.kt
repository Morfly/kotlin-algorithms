package leetcode.`347-top-k-frequent-elements`

import java.util.PriorityQueue

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (num in nums) {
        map[num] = map.getOrDefault(num, 0) + 1
    }

    val queue = PriorityQueue<Int>(compareByDescending { map[it] })
    for ((num, _) in map) {
        queue += num
    }
    return IntArray(k) { queue.remove() }
}

fun main() {
    val nums = intArrayOf(1, 1, 1, 2, 2, 3)

    val result = topKFrequent(nums, k = 2).toList()

    println(result)
    require(result == listOf(1, 2))
}