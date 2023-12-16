package foundation.`binary-search-tree`.recursive

import io.morfly.tools.printBinaryTree

class BinarySearchTree(var value: Int) {
    var left: BinarySearchTree? = null
    var right: BinarySearchTree? = null

    fun insert(key: Int) {
        if (key < this.value) {
            if (left == null) left = BinarySearchTree(key)
            else left!!.insert(key)
        } else {
            if (right == null) right = BinarySearchTree(key)
            else right!!.insert(key)
        }
    }

    operator fun contains(key: Int): Boolean =
        when {
            key < value -> left?.contains(key) ?: false
            key > value -> right?.contains(key) ?: false
            else -> true
        }

    fun delete(key: Int): BinarySearchTree? {
        when {
            key > value -> right = right?.delete(key)
            key < value -> left = left?.delete(key)
            else -> when {
                left == null -> return right
                right == null -> return left
                else -> {
                    var curr = right!!
                    while (curr.left != null) {
                        curr = curr.left!!
                    }
                    value = curr.value
                    right = right?.delete(value)
                }
            }
        }
        return this
    }
}

fun main() {
    val tree = BinarySearchTree(3).apply {
        insert(6)
        insert(1)
        insert(4)
        insert(7)
        insert(2)
    }
    tree.printBinaryTree()

    tree.insert(5)
    tree.printBinaryTree()

    tree.delete(6)?.printBinaryTree()
}