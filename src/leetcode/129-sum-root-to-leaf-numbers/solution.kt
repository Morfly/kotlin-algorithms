@file:Problem(companies = [Company.Meta], topics = [Topic.BinaryTree, Topic.DepthFirstSearch])

package leetcode.`129-sum-root-to-leaf-numbers`

@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
fun sumNumbers(root: TreeNode?): Int {

    fun traverse(node: TreeNode?, current: Int): Int {
        if (node == null) return 0

        val next = current * 10 + node.`val`

        return if (node.left == null && node.right == null) next
        else traverse(node.left, next) + traverse(node.right, next)
    }
    return traverse(root, current = 0)
}

fun main() {
    val input = node(1) {
        left = node(2)
        right = node(3)
    }

    val result = sumNumbers(input)

    println(result)
    require(result == 25)
}