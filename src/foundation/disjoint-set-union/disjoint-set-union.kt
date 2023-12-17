package foundation.`disjoint-set-union`

// https://youtu.be/ayW5B2W9hfo?si=WaGAHuPu0ggW7vv3
// https://cp-algorithms.com/data_structures/disjoint_set_union.html
class DisjointSet(size: Int) {
    private val parent = IntArray(size) { it }
    private val rank = IntArray(size) { 0 }

    fun find(p: Int): Int {
        if (parent[p] != p) {
            parent[p] = find(parent[p])
        }
        return parent[p]
    }

    fun union(p: Int, q: Int) {
        val rootP = find(p)
        val rootQ = find(q)

        if (rootP == rootQ) return

        when {
            rank[rootP] < rank[rootQ] -> parent[rootP] = rootQ
            rank[rootP] > rank[rootQ] -> parent[rootQ] = rootP
            else -> {
                parent[rootQ] = rootP
                rank[rootP]++
            }
        }
    }

    fun connected(p: Int, q: Int): Boolean =
        find(p) == find(q)
}

fun main() {
    val disjointSet = DisjointSet(10)

    disjointSet.union(1, 2)
    disjointSet.union(2, 3)
    disjointSet.union(4, 5)
    require(disjointSet.connected(1, 3))
    require(!disjointSet.connected(1, 5))

    disjointSet.union(3, 4)
    require(disjointSet.connected(1, 5))
}
