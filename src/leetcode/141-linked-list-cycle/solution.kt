@file:Problem(topics = [Topic.LinkedList, Topic.TwoPointers])

package leetcode.`141-linked-list-cycle`

@TimeComplexity("O(n)")
@SpaceComplexity("O(1)")
fun hasCycle(head: ListNode?): Boolean {
    var walker = head
    var runner = head
    while (walker != null && runner?.next != null) {
        walker = walker.next
        runner = runner.next?.next
        if (walker == runner) return true
    }

    return false
}

fun main() {
    val input = linkedListOf(3, 2, 0, -4, cycleIndex = 1)

    val result = hasCycle(input)

    println(result)
    require(result)
}