package leetcode.`426-convert-binary-search-tree-to-sorted-doubly-linked-list`

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
}

inline fun node(value: Int, nodes: Node.() -> Unit = {}): Node =
    Node(value).apply(nodes)

fun Node?.rightList(): List<Int> {
    if (this == null) return emptyList()

    val list = mutableListOf(`val`)
    var node = this.right
    while (node != this) {
        if (node == null) error("Invalid circular linked list")
        list += node.`val`
        node = node.right
    }
    return list
}

fun Node?.leftList(): List<Int> {
    if (this == null) return emptyList()

    val list = mutableListOf<Int>()
    var node = this.left
    while (node != this) {
        if (node == null) error("Invalid circular linked list")
        list += node.`val`
        node = node.left
    }
    list += this.`val`
    return list
}