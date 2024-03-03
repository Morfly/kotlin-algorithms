@file:Problem(companies = [Company.Meta], topics = [Topic.BinaryTree])

package leetcode.`1650-lowest-common-ancestor-of-a-binary-tree-III`.`solution-1`

import leetcode.`1650-lowest-common-ancestor-of-a-binary-tree-III`.Node
import leetcode.`1650-lowest-common-ancestor-of-a-binary-tree-III`.node

fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
    val parents = mutableSetOf<Node>()

    var node = p
    while (node != null) {
        parents += node
        node = node.parent
    }

    node = q
    while (node != null && node !in parents) {
        node = node.parent
    }
    return node
}

fun main() {
    var p: Node? = null
    var q: Node? = null
    val root = node(3) {
        left = node(5) {
            left = node(6)
            right = node(2) {
                left = node(7)
                right = node(4)
            }
        }.also { p = it }
        right = node(1) {
            left = node(0)
            right = node(8)
        }.also { q = it }
    }

    val result = lowestCommonAncestor(p, q)

    println(result?.`val`)
    require(result == root)
}