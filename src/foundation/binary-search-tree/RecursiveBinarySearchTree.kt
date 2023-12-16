package foundation.`binary-search-tree`.recursive

import io.morfly.tools.print
import io.morfly.tools.printBinaryTree

class BinarySearchTree(var value: Int) {
    var left: BinarySearchTree? = null
    var right: BinarySearchTree? = null

    fun insert(value: Int) {
        if (value < this.value) {
            if (left == null) left = BinarySearchTree(value)
            else left!!.insert(value)
        } else {
            if (right == null) right = BinarySearchTree(value)
            else right!!.insert(value)
        }
    }

    operator fun contains(value: Int): Boolean =
        when {
            value < this.value -> left?.contains(value) ?: false
            value > this.value -> right?.contains(value) ?: false
            else -> true
        }

    fun delete(value: Int): BinarySearchTree {
        when {
            value > this.value -> right = right?.delete(value)
            value < this.value -> left = left?.delete(value)
            else -> when {
                left == null -> right
                right == null -> left
                else -> {
                    var curr = right!!
                    while (curr.left != null) {
                        curr = curr.left!!
                    }
                    this.value = curr.value
                    right = right?.delete(value)
                }
            }
        }
        return this
    }
}

fun main() {
    val tree = BinarySearchTree(3).apply {
        insert(5)
        insert(1)
        insert(4)
        insert(2)
    }

    tree.printBinaryTree()
    tree.insert(10)
    tree.printBinaryTree()
    tree.delete(3).printBinaryTree()
}