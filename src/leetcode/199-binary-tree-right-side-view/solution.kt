package leetcode.`199-binary-tree-right-side-view`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun rightSideView(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    var maxLevel = -1

    fun traverse(node: TreeNode?, level: Int) {
        if (node == null) return

        if (level > maxLevel) {
            maxLevel = level
            result += node.`val`
        }
        traverse(node.right, level + 1)
        traverse(node.left, level + 1)
    }
    traverse(root, level = 0)

    return result
}

fun main() {
    val tree = node(4) {
        left = node(2) {
            left = node(1)
            right = node(3) {
                left = node(10)
            }
        }
        right = node(7) {
            left = node(6)
            right = node(9)
        }
    }

    val result = rightSideView(tree)

    println(result)
    require(result == listOf(4, 7, 9, 10))
}

inline fun node(value: Int, nodes: TreeNode.() -> Unit = {}) =
    TreeNode(value).apply(nodes)