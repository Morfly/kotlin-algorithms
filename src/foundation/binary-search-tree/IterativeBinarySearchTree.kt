package foundation.`binary-search-tree`.iterative

class BinarySearchTree(val value: Int) {
    var left: BinarySearchTree? = null
        private set
    var right: BinarySearchTree? = null
        private set

    fun insert(value: Int) {
        var currNode: BinarySearchTree? = this
        while (true) {
            if (value < currNode!!.value) {
                if (currNode.left == null) {
                    currNode.left = BinarySearchTree(value)
                    break
                } else currNode = currNode.left

            } else {
                if (currNode.right == null) {
                    currNode.right = BinarySearchTree(value)
                    break
                } else currNode = currNode.right
            }
        }
    }

    operator fun contains(value: Int): Boolean {
        var currNode: BinarySearchTree? = this
        while (currNode != null) {
            currNode = when {
                value < currNode.value -> currNode.left
                value > currNode.value -> currNode.right
                else -> return true
            }
        }
        return false
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