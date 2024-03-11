package leetcode.`94-binary-tree-inorder-traversal`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

inline fun node(value: Int, nodes: TreeNode.() -> Unit = {}): TreeNode =
    TreeNode(value).apply(nodes)