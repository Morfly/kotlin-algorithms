package foundation.`minimum-spanning-tree`.kruskal

class DisjointSet<T> {
    private val parent = mutableMapOf<T, T>()
    private val rank = mutableMapOf<T, Int>()

    fun find(p: T): T {
        if (p !in parent) parent[p] = p

        if (parent[p] != p) {
            parent[p] = find(parent[p]!!)
        }
        return parent[p]!!
    }

    fun union(p: T, q: T) {
        val rootP = find(p)
        val rootQ = find(q)

        if (rootP == rootQ) return

        val rankP = rank[rootP] ?: 0
        val rankQ = rank[rootQ] ?: 0
        when {
            rankP < rankQ -> parent[rootP] = rootQ
            rankP > rankQ -> parent[rootQ] = rootP
            else -> {
                parent[rootQ] = rootP
                rank[rootP] = rankP + 1
            }
        }
    }
}
