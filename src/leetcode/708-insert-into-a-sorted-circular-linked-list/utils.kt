package leetcode.`708-insert-into-a-sorted-circular-linked-list`

fun circularListOf(vararg elements: Int): Node? {
    if (elements.isEmpty()) return null
    val wrapper = Node(0)
    var node = wrapper
    for (i in elements) {
        node.next = Node(i)
        node = node.next!!
    }
    node.next = wrapper.next

    return wrapper.next
}

fun Node?.toList(): List<Int> {
    if (this == null) return emptyList()

    val result = mutableListOf<Int>()
    var node: Node = this
    do {
        result += node.`val`
        node = node.next!!
    } while (node != this)

    return result
}
