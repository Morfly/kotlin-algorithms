package leetcode.`160-intersection-of-two-linked-lists`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * Produce two intersected linked lists.
 *
 * @param intersectVal The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * @param listA The first linked list.
 * @param listB The second linked list.
 * @param skipA The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * @param skipB The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 * @return Head of list A, head of list B, intersection node.
 */
fun intersectedLists(
    intersectVal: Int,
    listA: List<Int>,
    listB: List<Int>,
    skipA: Int,
    skipB: Int
): Triple<ListNode?, ListNode?, ListNode?> {
    var intersection: ListNode? = null

    val wrapperA = ListNode(0)
    var nodeA = wrapperA
    for (i in listA.indices) {
        val next = ListNode(listA[i])
        if (intersectVal != 0 && i == skipA) {
            if (next.`val` != intersectVal)
                error("Invalid intersectVal in listA. Expected $intersectVal but was ${next.`val`}")
            intersection = next
        }
        nodeA.next = next
        nodeA = next
    }

    val wrapperB = ListNode(0)
    var nodeB = wrapperB
    for (i in listB.indices) {
        if (intersectVal != 0 && i == skipB) {
            if (listB[i] != intersectVal)
                error("Invalid intersectVal in listB. Expected $intersectVal but was ${listB[i]}")
            nodeB.next = intersection
            break
        }
        val next = ListNode(listB[i])
        nodeB.next = next
        nodeB = next
    }

    return Triple(wrapperA.next, wrapperB.next, intersection)
}
