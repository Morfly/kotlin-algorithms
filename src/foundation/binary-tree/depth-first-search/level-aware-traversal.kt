package foundation.`binary-tree`.`depth-first-search`.`level-aware`

class BinaryTree<T>(
    val value: T,
    var left: BinaryTree<T>? = null,
    var right: BinaryTree<T>? = null,
)

fun <T> BinaryTree<T>.traverse(): List<List<T>> {
    val explored = mutableListOf<MutableList<T>>()

    fun traverse(node: BinaryTree<T>?, level: Int) {
        if (node == null) return

        if (explored.size == level) {
            explored += mutableListOf<T>()
        }

        explored[level] += node.value
        traverse(node.left, level + 1)
        traverse(node.right, level + 1)
    }
    traverse(this, level = 0)

    return explored
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
    require(nodes == listOf(listOf(1), listOf(2, 3), listOf(4, 5)))
}

inline fun <T> node(value: T, nodes: BinaryTree<T>.() -> Unit = {}) =
    BinaryTree(value).apply(nodes)
