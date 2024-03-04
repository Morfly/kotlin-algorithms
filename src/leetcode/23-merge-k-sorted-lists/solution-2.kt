@file:Problem(companies = [Company.Meta], topics = [Topic.Sorting, Topic.MergeSort, Topic.LinkedList])

package leetcode.`23-merge-k-sorted-lists`.`solution-2`

import leetcode.`23-merge-k-sorted-lists`.*

// n - number of elements in the list, k = number of lists
@TimeComplexity("O(n log k)")
@SpaceComplexity("O(1)")
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) return null

    var result = mutableListOf(*lists)

    while (result.size > 1) {
        val merged = mutableListOf<ListNode?>()

        for (i in 0..result.lastIndex step 2) {
            val list1 = result[i]
            val list2 = if (i + 1 <= result.lastIndex) result[i + 1] else null
            merged += mergeTwoLists(list1, list2)
        }
        result = merged
    }
    return result.first()
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val wrapper = ListNode(0)
    var node = wrapper

    var node1 = list1
    var node2 = list2
    while (node1 != null && node2 != null) {
        if (node1.`val` < node2.`val`) {
            node.next = node1
            node = node1

            node1 = node1.next
        } else {
            node.next = node2
            node = node2

            node2 = node2.next
        }
    }
    node.next = node1 ?: node2

    return wrapper.next
}

// https://leetcode.com/problems/merge-two-sorted-lists/solutions/1826693/python3-merging-explained/
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
