@file:Problem(topics = [Topic.BinaryTree, Topic.DepthFirstSearch])

package leetcode.`94-binary-tree-inorder-traversal`.`solution-1`

import leetcode.`94-binary-tree-inorder-traversal`.*

@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun traverse(node: TreeNode?) {
        if (node == null) return

        traverse(node.left)
        result += node.`val`
        traverse(node.right)
    }
    traverse(root)

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