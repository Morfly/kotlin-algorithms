package leetcode.`1650-lowest-common-ancestor-of-a-binary-tree-III`

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var parent: Node? = null
}

inline fun node(value: Int, nodes: Node.() -> Unit = {}): Node {
    val node = Node(value)
    node.apply(nodes)
    node.left?.let { it.parent = node }
    node.right?.let { it.parent = node }
    return node
}
