@file:Meta(companies = [Company.Meta], topics = [Topic.BinarySearchTree, Topic.DepthFirstSearch, Topic.LinkedList])

package leetcode.`426-convert-binary-search-tree-to-sorted-doubly-linked-list`

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
}

@TimeComplexity("O(n)")
@SpaceComplexity("O(1)")
fun treeToDoublyList(root: Node?): Node? {
    val wrapper = Node(0)

    var listNode = wrapper
    fun traverse(treeNode: Node?) {
        if (treeNode == null) return

        traverse(treeNode.left)

        listNode.right = treeNode
        treeNode.left = listNode
        listNode = treeNode

        traverse(treeNode.right)
    }
    traverse(root)

    val head = wrapper.right
    val tail = listNode
    head?.left = tail
    tail.right = head

    return head
}

fun main() {
    val tree = node(4) {
        left = node(2) {
            left = node(1)
            right = node(3)
        }
        right = node(5)
    }

    val result = treeToDoublyList(tree)

    val list = result.rightList()
    val reversed = result.leftList()
    println(list)
    require(list == reversed.asReversed())
}

inline fun node(value: Int, nodes: Node.() -> Unit = {}): Node =
    Node(value).apply(nodes)

