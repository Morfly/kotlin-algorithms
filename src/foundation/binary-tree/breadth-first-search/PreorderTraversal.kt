package foundation.`binary-tree`.`breadth-first-search`.preorder

class BinaryTree<T>(
    val value: T,
    var left: BinaryTree<T>? = null,
    var right: BinaryTree<T>? = null,
)

fun <T> BinaryTree<T>.traverse(): List<T> {
    val explored = mutableListOf<T>()

    fun traverse(node: BinaryTree<T>?) {
        if (node == null) return

        explored += node.value
        traverse(node.left)
        traverse(node.right)
    }
    traverse(this)

    return explored
}

fun main() {
    val tree = node(1) {
        left = node(2) {
            left = node(3)
            right = node(4)
        }
        right = node(5)
    }

    val nodes = tree.traverse()

    println(nodes)
    require(nodes == listOf(1, 2, 3, 4, 5))
}

inline fun <T> node(value: T, nodes: BinaryTree<T>.() -> Unit = {}) =
    BinaryTree(value).apply(nodes)