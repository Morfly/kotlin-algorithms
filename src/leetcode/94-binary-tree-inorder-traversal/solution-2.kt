@file:Problem(topics = [Topic.BinaryTree])

package leetcode.`94-binary-tree-inorder-traversal`.`solution-2`

import leetcode.`94-binary-tree-inorder-traversal`.*

@TimeComplexity("O(n)")
@SpaceComplexity("O(1)")
fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    var prev: TreeNode
    var curr = root
    while (curr != null) {
        if (curr.left == null) {
            result += curr.`val`
            curr = curr.right
            continue
        }

        prev = curr.left!!
        while (prev.right != null && prev.right != curr) {
            prev = prev.right!!
        }

        if (prev.right == null) {
            prev.right = curr
            curr = curr.left
        } else {
            prev.right = null
            result += curr.`val`
            curr = curr.right
        }
    }

    return result
}

fun main() {
    val input = node(1) {
        right = node(2) {
            left = node(3)
        }
    }

    val result = inorderTraversal(input)

    println(result)
    require(result == listOf(1, 3, 2))
}