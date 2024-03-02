@file:Meta(companies = [Company.Meta], topics = [Topic.BinaryTree, Topic.BinarySearchTree, Topic.DepthFirstSearch])

package leetcode.`938-range-sum-of-bst`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

@TimeComplexity("O(n)")
@SpaceComplexity("O(1)")
fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    var sum = 0

    fun traverse(node: TreeNode?, min: Int, max: Int) {
        if (node == null || max < low || high < min) return

        traverse(node.left, min, max = node.`val`)
        traverse(node.right, min = node.`val`, max)

        if (node.`val` in low..high) {
            sum += node.`val`
        }
    }
    traverse(root, min = 1, max = Int.MAX_VALUE)

    return sum
}

fun main() {
    val tree = node(10) {
        left = node(5) {
            left = node(3)
            right = node(7)
        }
        right = node(15) {
            right = node(18)
        }
    }

    val result = rangeSumBST(tree, low = 7, high = 15)

    println(result)
    require(result == 32)
}

inline fun node(value: Int, nodes: TreeNode.() -> Unit = {}): TreeNode =
    TreeNode(value).apply(nodes)