package foundation.`disjoint-set-union`.`hash-map`

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

    fun connected(p: T, q: T): Boolean =
        find(p) == find(q)
}

fun main() {
    val disjointSet = DisjointSet<String>()

    disjointSet.union("A", "B")
    disjointSet.union("B", "C")
    disjointSet.union("D", "E")
    require(disjointSet.connected("A", "C"))
    require(!disjointSet.connected("A", "E"))

    disjointSet.union("C", "D")
    require(disjointSet.connected("A", "E"))
}
