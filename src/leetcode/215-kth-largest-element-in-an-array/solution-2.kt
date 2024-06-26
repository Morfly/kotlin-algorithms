@file:Problem(companies = [Company.Meta], topics = [Topic.Heap])

package leetcode.`215-kth-largest-element-in-an-array`.`solution-2`

import java.util.*

// It costs O(log k) to push an element n times in a heap of size k.
@TimeComplexity("O(n log k)")
@SpaceComplexity("O(k)")
fun findKthLargest(nums: IntArray, k: Int): Int {
    val heap = PriorityQueue<Int>(k)

    for (num in nums) {
        heap += num
        if (heap.size > k) {
            heap.remove()
        }
    }

    return heap.peek()
}

// https://stackoverflow.com/a/65749227
fun main() {
    val input = intArrayOf(3, 2, 1, 5, 6, 4)

    val result = findKthLargest(input, k = 2)

    println(result)
    require(result == 5)
}