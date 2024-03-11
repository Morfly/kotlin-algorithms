package leetcode.`129-sum-root-to-leaf-numbers`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

inline fun node(value: Int, nodes: TreeNode.() -> Unit = {}): TreeNode =
    TreeNode(value).apply(nodes)