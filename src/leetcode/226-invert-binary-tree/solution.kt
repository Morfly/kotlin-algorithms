package leetcode.`226-invert-binary-tree`

import io.morfly.algorithms.tools.printBinaryTree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

// https://leetcode.com/problems/invert-binary-tree/description/
fun invertTree(root: TreeNode?): TreeNode? =
    root?.apply {
        left = invertTree(left)
        right = invertTree(right)
        left = right.also { right = left }
    }

fun main() {
    val tree = node(4) {
        left = node(2) {
            left = node(1)
            right = node(3)
        }
        right = node(7) {
            left = node(6)
            right = node(9)
        }
    }

    val result = invertTree(tree)

    result?.printBinaryTree()
}

inline fun node(value: Int, nodes: TreeNode.() -> Unit = {}) =
    TreeNode(value).apply(nodes)