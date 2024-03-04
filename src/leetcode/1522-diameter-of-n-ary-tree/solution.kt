@file:Problem(companies = [Company.Meta], topics = [Topic.DepthFirstSearch, Topic.Tree, Topic.Recursion])

package leetcode.`1522-diameter-of-n-ary-tree`

import java.util.*

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

// n - number of nodes, h - tree height.
@TimeComplexity("O(n)")
@SpaceComplexity("O(h)")
fun diameter(root: Node?): Int {
    var diameter = 0

    fun traverse(node: Node?): Int {
        if (node == null) return 0
        if (node.children.isEmpty()) return 1

        val heap = PriorityQueue<Int>()

        for (child in node.children) {
            heap += traverse(child)
            if (heap.size > 2) {
                heap.remove()
            }
        }

        var distance = 0
        var longestChild = 0
        while (heap.isNotEmpty()) {
            longestChild = heap.remove()
            distance += longestChild
        }

        diameter = maxOf(diameter, distance)

        return longestChild + 1
    }
    traverse(root)

    return diameter
}

fun main() {
    val tree = node(1) {
        node(2)
        node(3) {
            node(6)
            node(7) {
                node(11) {
                    node(14)
                }
            }
        }
        node(4) {
            node(8) {
                node(12)
            }
        }
        node(5) {
            node(9) {
                node(13)
            }
            node(10)
        }
    }

    val result = diameter(tree)

    println(result)
    require(result == 7)
}

inline fun node(value: Int, nodes: Node.() -> Unit = {}): Node =
    Node(value).apply(nodes)

inline fun Node.node(value: Int, nodes: Node.() -> Unit = {}) {
    children += Node(value).apply(nodes)
}