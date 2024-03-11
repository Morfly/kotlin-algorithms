package leetcode.`428-serialize-and-deserialize-n-ary-tree`

class Node(var `val`: Int) {
    var children: List<Node?> = mutableListOf()
}

inline fun node(value: Int, nodes: Node.() -> Unit = {}): Node =
    Node(value).apply(nodes)

inline fun Node.node(value: Int, nodes: Node.() -> Unit = {}): Node {
    val node = Node(value).apply(nodes)
    (children as MutableList) += node
    return node
}