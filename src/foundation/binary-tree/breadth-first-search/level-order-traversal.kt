package foundation.`binary-tree`.`breadth-first-search`

class BinaryTree<T>(
    val value: T,
    var left: BinaryTree<T>? = null,
    var right: BinaryTree<T>? = null,
)

fun <T> BinaryTree<T>.traverse(): List<T> {
    val explored = linkedSetOf<BinaryTree<T>>()
    val queue = ArrayDeque<BinaryTree<T>>()
    queue += this

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()

        if (node !in explored) {
            explored += node

            val left = node.left
            if (left != null) queue += left

            val right = node.right
            if (right != null) queue += right
        }
    }
    return explored.map { it.value }
}

fun main() {
    val tree = node(1) {
        left = node(2) {
            left = node(4)
            right = node(5)
        }
        right = node(3)
    }

    val nodes = tree.traverse()

    println(nodes)
    require(nodes == listOf(1, 2, 3, 4, 5))
}

inline fun <T> node(value: T, nodes: BinaryTree<T>.() -> Unit = {}) =
    BinaryTree(value).apply(nodes)
