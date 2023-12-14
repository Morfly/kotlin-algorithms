package foundation.`binary-search-tree`.recursive

class BinarySearchTree(val value: Int) {
    var left: BinarySearchTree? = null
        private set
    var right: BinarySearchTree? = null
        private set

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
}