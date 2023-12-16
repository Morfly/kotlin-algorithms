package leetcode.`450`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

// https://leetcode.com/problems/delete-node-in-a-bst/description/
// https://www.youtube.com/watch?v=LFzAoJJt92M
fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
    if (root == null) return null

    when {
        key > root.`val` -> root.right = deleteNode(root.right, key)
        key < root.`val` -> root.left = deleteNode(root.left, key)
        else -> when {
            root.left == null -> return root.right
            root.right == null -> return root.left
            else -> {
                var curr = root.right
                while (curr?.left != null) {
                    curr = curr.left
                }
                root.`val` = curr!!.`val`
                root.right = deleteNode(root.right, root.`val`)
            }
        }
    }
    return root
}