package leetcode.`23-merge-k-sorted-lists`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun linkedListOf(vararg values: Int): ListNode? {
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