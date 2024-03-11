package foundation.`binary-tree`.`morris-traversal`.preorder

class BinaryTree(
    val value: Int,
    var left: BinaryTree? = null,
    var right: BinaryTree? = null,
)

@TimeComplexity("O(n)")
@SpaceComplexity("O(1)")
fun BinaryTree.traverse(): List<Int> {
    val explored = mutableListOf<Int>()

    var prev: BinaryTree
    var curr: BinaryTree? = this
    while (curr != null) {
        if (curr.left == null) {
            explored += curr.value
            curr = curr.right
            continue
        }

        prev = curr.left!!
        while (prev.right != null && prev.right != curr) {
            prev = prev.right!!
        }

        if (prev.right == null) {
            prev.right = curr
            explored += curr.value
            curr = curr.left
        } else {
            prev.right = null
            curr = curr.right
        }
    }
    return explored
}

// https://youtu.be/wGXB9OWhPTg?si=3zRV1jMiniCxeTgw
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

inline fun node(value: Int, nodes: BinaryTree.() -> Unit = {}): BinaryTree =
    BinaryTree(value).apply(nodes)