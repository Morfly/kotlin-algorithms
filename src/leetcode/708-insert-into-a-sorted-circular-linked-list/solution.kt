package leetcode.`708-insert-into-a-sorted-circular-linked-list`

class Node(var `val`: Int) {
    var next: Node? = null
}

fun insert(head: Node?, insertVal: Int): Node? {
    if (head == null) {
        val node = Node(insertVal)
        node.insert(node)
        return node
    }

    var node: Node = head
    while (true) {
        val allNodesSame = node.next == head && node.`val` == head.`val`
        if (allNodesSame) break

        val end = node.`val` > node.next!!.`val`
        if (end) {
            val greatest = insertVal >= node.`val`
            val smallest = insertVal <= node.next!!.`val`
            if (greatest || smallest) break
        }

        if (insertVal in node.`val`..node.next!!.`val`) break

        node = node.next!!
    }

    node.insert(Node(insertVal))
    return head
}

private fun Node.insert(new: Node) {
    new.next = this.next
    this.next = new
}

fun main() {
    val input = circularListOf(3, 4, 1)

    val result = insert(input, insertVal = 2).toList()

    println(result)
    require(result == listOf(3, 4, 1, 2))
}