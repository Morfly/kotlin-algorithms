package foundation.`binary-tree`.`depth-first-search`.postorder

class BinaryTree<T>(
    val value: T,
    var left: BinaryTree<T>? = null,
    var right: BinaryTree<T>? = null,
)

fun <T> BinaryTree<T>.traverse(): List<T> {
    val explored = mutableListOf<T>()

    fun traverse(node: BinaryTree<T>?) {
        if (node == null) return

        traverse(node.left)
        traverse(node.right)
        explored += node.value
    }
    traverse(this)

    return explored
}

fun main() {
    val tree = node(5) {
        left = node(3) {
            left = node(1)
            right = node(2)
        }
        right = node(4)
    }

    val nodes = tree.traverse()

    println(nodes)
    require(nodes == listOf(1, 2, 3, 4, 5))
}

inline fun <T> node(value: T, nodes: BinaryTree<T>.() -> Unit = {}) =
    BinaryTree(value).apply(nodes)