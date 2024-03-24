package leetcode.`141-linked-list-cycle`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun linkedListOf(vararg values: Int, cycleIndex: Int): ListNode? {
    val wrapper = ListNode(0)

    var node = wrapper
    var cycleNode: ListNode? = null
    for ((i, value) in values.withIndex()) {
        node.next = ListNode(value)
        node = node.next!!
        if (i == cycleIndex) {
            cycleNode = node
        }
    }

    node.next = cycleNode
    return wrapper.next
}