@file:Problem(companies = [Company.Meta], topics = [Topic.BinaryTree, Topic.BreadthFirstSearch])

package leetcode.`314-binary-tree-vertical-order-traversal`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

typealias Column = Int

// https://leetcode.com/problems/binary-tree-vertical-order-traversal
fun verticalOrder(root: TreeNode?): List<List<Int>> {
    val columns = mutableMapOf<Column, MutableList<Int>>()

    val queue = ArrayDeque<Pair<Column, TreeNode?>>()
    queue += 0 to root

    while (queue.isNotEmpty()) {
        val (col, node) = queue.removeFirst()
        if (node == null) continue

        if (col !in columns) {
            columns[col] = mutableListOf()
        }
        columns[col]!! += node.`val`

        queue += (col - 1) to node.left
        queue += (col + 1) to node.right
    }

    if (columns.isEmpty()) return emptyList()

    val result = mutableListOf<MutableList<Int>>()
    val low = columns.keys.min()
    val high = columns.keys.max()
    for (i in low..high) {
        result += columns[i]!!
    }
    return result
}

fun main() {
    val tree = node(3) {
        left = node(9) {
            left = node(4)
            right = node(0) {
                right = node(2)
            }
        }
        right = node(8) {
            left = node(1) {
                left = node(5)
            }
            right = node(7)
        }
    }

    val result = verticalOrder(tree)

    println(result)
    require(result == listOf(listOf(4), listOf(9, 5), listOf(3, 0, 1), listOf(8, 2), listOf(7)))
}

inline fun node(value: Int, nodes: TreeNode.() -> Unit = {}): TreeNode =
    TreeNode(value).apply(nodes)
