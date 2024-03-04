@file:Problem(companies = [Company.Meta], topics = [Topic.Sorting, Topic.LinkedList])

package leetcode.`23-merge-k-sorted-lists`.`solution-3`

import leetcode.`23-merge-k-sorted-lists`.*
import java.util.*

// n - total number of elements in a resulting list, k - number of input lists
@TimeComplexity("O(n log k)")
@SpaceComplexity("O(k)")
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) return null
    if (lists.size == 1) return lists.first()

    val heap = PriorityQueue(compareBy(ListNode::`val`))

    for (list in lists) {
        if (list == null) continue
        heap += list
    }

    val wrapper = ListNode(0)
    var node = wrapper
    while (heap.isNotEmpty()) {
        val minNode = heap.remove()
        node.next = minNode
        node = minNode

        val next = minNode.next
        if (next != null) heap += next
    }

    return wrapper.next
}


fun main() {
    val lists = arrayOf(
        linkedListOf(1, 4, 5),
        linkedListOf(1, 3, 4),
        linkedListOf(2, 6),
    )

    val result = mergeKLists(lists).toList()

    println(result)
    require(result == listOf(1, 1, 2, 3, 4, 4, 5, 6))
}
