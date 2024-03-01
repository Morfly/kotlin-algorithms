@file:Meta(companies = [Company.Meta], topics = [Topic.Heap])

package leetcode.`215-kth-largest-element-in-an-array`.`solution-3`

import java.util.*

// Wrapper around integer to heapify as max heap ensuring a descending comparison order.
data class IntWrapper(val value: Int) : Comparable<IntWrapper> {
    override fun compareTo(other: IntWrapper) = comparator.compare(this, other)

    companion object {
        val comparator = compareByDescending<IntWrapper> { it.value }
    }
}

@TimeComplexity("O(n + k log n)", Comment("It costs O(n) to heapify a list and O(k log n) to pop k times."))
@SpaceComplexity("O(n)")
fun findKthLargest(nums: IntArray, k: Int): Int {
    val heap = PriorityQueue(nums.map(::IntWrapper))

    for (i in 1 until k) {
        heap.remove()
    }

    return heap.peek().value
}

fun main() {
    val input = intArrayOf(3, 2, 1, 5, 6, 4)

    val result = findKthLargest(input, k = 2)

    println(result)
    require(result == 5)
}