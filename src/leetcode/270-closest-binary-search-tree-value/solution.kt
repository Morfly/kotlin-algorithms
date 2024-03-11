@file:Problem(companies = [Company.Meta], topics = [Topic.BinarySearchTree, Topic.DepthFirstSearch, Topic.Recursion])

package leetcode.`270-closest-binary-search-tree-value`

import kotlin.math.abs

@TimeComplexity("O(n)")
@SpaceComplexity("O(log n)")
fun closestValue(root: TreeNode?, target: Double): Int {
    var minDiff = Double.MAX_VALUE
    var closest = Int.MAX_VALUE

    fun traverse(node: TreeNode?) {
        if (node == null) return

        val diff = abs(node.`val` - target)
        if (diff < minDiff) {
            minDiff = diff
            closest = node.`val`
        } else if (diff == minDiff && node.`val` < closest) {
            closest = node.`val`
        }

        if (target < node.`val`) {
            traverse(node.left)
        } else if (target > node.`val`) {
            traverse(node.right)
        }
    }
    traverse(root)

    return closest
}

fun main() {
    val input = node(4) {
        left = node(2) {
            left = node(1)
            right = node(3)
        }
        right = node(5)
    }

    val result = closestValue(input, target = 3.5)

    println(result)
    require(result == 3)
}
