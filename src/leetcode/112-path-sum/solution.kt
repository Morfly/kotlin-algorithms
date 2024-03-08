@file:Problem(topics = [Topic.BinaryTree, Topic.DepthFirstSearch])

package leetcode.`112-path-sum`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

@TimeComplexity("O(n)")
@SpaceComplexity("O(log n)")
fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {

    fun traverse(node: TreeNode?, target: Int): Boolean {
        if (node == null) return false

        val current = target - node.`val`
        return if (current == 0 && node.left == null && node.right == null) {
            true
        } else {
            traverse(node.left, current) || traverse(node.right, current)
        }
    }
    return traverse(root, targetSum)
}

fun main() {
    val input = node(5) {
        left = node(4) {
            left = node(11) {
                left = node(7)
                right = node(2)
            }
        }
        right = node(8) {
            left = node(13)
            right = node(4) {
                right = node(1)
            }
        }
    }

    val result = hasPathSum(input, targetSum = 22)

    println(result)
    require(result)
}

inline fun node(value: Int, nodes: TreeNode.() -> Unit = {}): TreeNode =
    TreeNode(value).apply(nodes)