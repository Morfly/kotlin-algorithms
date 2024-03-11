@file:Problem(companies = [Company.Meta], topics = [Topic.BinaryTree, Topic.DepthFirstSearch])

package leetcode.`543-diameter-of-binary-tree`

@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
fun diameterOfBinaryTree(root: TreeNode?): Int {
    var diameter = 0

    fun traverse(node: TreeNode?): Int {
        if (node == null) return 0

        val left = traverse(node.left)
        val right = traverse(node.right)
        val length = left + right

        diameter = maxOf(diameter, length)

        return maxOf(left, right) + 1
    }
    traverse(root)

    return diameter
}

fun main() {
    val input = node(1) {
        left = node(2) {
            left = node(4)
            right = node(5)
        }
        right = node(3)
    }

    val result = diameterOfBinaryTree(input)

    println(result)
    require(result == 3)
}