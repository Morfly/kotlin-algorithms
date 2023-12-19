package foundation.`binary-search-tree`.validation

class BinaryTree(
    val value: Int,
    var left: BinaryTree? = null,
    var right: BinaryTree? = null
)

fun BinaryTree.isBinarySearchTree(): Boolean {

    fun validate(node: BinaryTree?, minValue: Int, maxValue: Int): Boolean {
        if (node == null) return true
        if (node.value < minValue || node.value >= maxValue) return false

        val isLeftValid = validate(node.left, minValue, node.value)
        val isRightValid = validate(node.right, node.value, maxValue)
        return isLeftValid && isRightValid
    }

    return validate(this, Int.MIN_VALUE, Int.MAX_VALUE)
}

fun main() {
    val tree = node(6) {
        left = node(4) {
            left = node(0)
            right = node(5)
        }
        right = node(10) {
            left = node(7)
            right = node(11)
        }
    }

    val isBinarySearchTree = tree.isBinarySearchTree()

    println(isBinarySearchTree)
    require(isBinarySearchTree)
}

inline fun node(value: Int, nodes: BinaryTree.() -> Unit = {}) =
    BinaryTree(value).apply(nodes)
