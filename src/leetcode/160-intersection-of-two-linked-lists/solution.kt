@file:Problem(topics = [Topic.LinkedList])

package leetcode.`160-intersection-of-two-linked-lists`

fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var nodeA = headA
    var nodeB = headB
    while (nodeA != nodeB) {
        nodeA = if (nodeA != null) nodeA.next else headB
        nodeB = if (nodeB != null) nodeB.next else headA
    }
    return nodeA
}

fun main() {
    val (headA, headB, intersection) = intersectedLists(
        intersectVal = 8,
        listA = listOf(4, 1, 8, 4, 5),
        listB = listOf(5, 6, 1, 8, 4, 5),
        skipA = 2,
        skipB = 3
    )

    val result = getIntersectionNode(headA, headB)

    println(result?.`val`)
    require(result == intersection)
}