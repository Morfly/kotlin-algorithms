@file:Problem(companies = [Company.Meta], topics = [Topic.BinaryTree, Topic.LinkedList])

package leetcode.`1650-lowest-common-ancestor-of-a-binary-tree-III`.`solution-2`

import leetcode.`1650-lowest-common-ancestor-of-a-binary-tree-III`.Node
import leetcode.`1650-lowest-common-ancestor-of-a-binary-tree-III`.node

fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
    var nodeP = p
    var nodeQ = q
    while (nodeP != nodeQ) {
        nodeP = if (nodeP != null) nodeP.parent else q
        nodeQ = if (nodeQ != null) nodeQ.parent else p
    }
    return nodeP
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