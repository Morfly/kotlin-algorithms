@file:Problem(topics = [Topic.LinkedList, Topic.Sorting])

package leetcode.`21-merge-two-sorted-lists`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

@TimeComplexity("O(n)")
@SpaceComplexity("O(1)")
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
    val list1 = linkedListOf(1, 2, 4)
    val list2 = linkedListOf(1, 3, 4, 5)

    val result = mergeTwoLists(list1, list2).toList()

    println(result)
    require(result == listOf(1, 1, 2, 3, 4, 4, 5))
}

