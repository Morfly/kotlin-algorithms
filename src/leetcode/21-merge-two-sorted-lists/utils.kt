package leetcode.`21-merge-two-sorted-lists`

fun linkedListOf(vararg values: Int): ListNode? {
    if (values.isEmpty()) return null

    val wrapper = ListNode(0)
    var node = wrapper
    for (value in values) {
        val next = ListNode(value)
        node.next = next
        node = next
    }
    return wrapper.next
}

fun ListNode?.toList(): List<Int> {
    val result = mutableListOf<Int>()
    var node = this
    while (node != null) {
        result += node.`val`
        node = node.next
    }
    return result
}