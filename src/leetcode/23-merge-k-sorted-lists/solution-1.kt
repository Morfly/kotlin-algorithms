@file:Problem(companies = [Company.Meta], topics = [Topic.Sorting, Topic.LinkedList])

package leetcode.`23-merge-k-sorted-lists`.`solution-1`

import leetcode.`23-merge-k-sorted-lists`.*

// n - number of elements in the list, k - number of input lists
@TimeComplexity("O(n * k)")
@SpaceComplexity("O(1)")
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) return null
    if (lists.size == 1) return lists.first()

    var list = lists.first()
    for (i in 1..lists.lastIndex) {
        list = mergeTwoLists(list, lists[i])
    }
    return list
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
