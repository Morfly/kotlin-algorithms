package leetcode.`270-closest-binary-search-tree-value`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

inline fun node(value: Int, nodes: TreeNode.() -> Unit = {}): TreeNode =
    TreeNode(value).apply(nodes)