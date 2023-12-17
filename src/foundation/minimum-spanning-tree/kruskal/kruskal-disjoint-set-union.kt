package foundation.`minimum-spanning-tree`.kruskal

import foundation.`disjoint-set-union`.DisjointSet

data class Edge(
    val src: Int,
    val dest: Int,
    val weight: Int
) : Comparable<Edge> {

    override fun compareTo(other: Edge): Int = weight.compareTo(other.weight)
}

fun minSpanningTree(edges: List<Edge>): List<Edge> {
    val minSpanningTree = mutableListOf<Edge>()

    var maxVertexValue = 0
    for (edge in edges) {
        maxVertexValue = maxOf(maxVertexValue, edge.src, edge.dest)
    }
    val disjointSet = DisjointSet(maxVertexValue + 1)

    val sortedEdges = edges.sorted()
    for (edge in sortedEdges) {
        val src = disjointSet.find(edge.src)
        val dest = disjointSet.find(edge.dest)

        if (src != dest) {
            minSpanningTree += edge
            disjointSet.union(src, dest)
        }
    }
    return minSpanningTree
}

fun main() {
    val edges = listOf(
        Edge(src = 5, dest = 1, weight = 4),
        Edge(src = 5, dest = 4, weight = 9),
        Edge(src = 1, dest = 4, weight = 1),
        Edge(src = 1, dest = 2, weight = 2),
        Edge(src = 2, dest = 4, weight = 3),
        Edge(src = 2, dest = 3, weight = 3),
        Edge(src = 3, dest = 4, weight = 5),
        Edge(src = 2, dest = 6, weight = 7),
        Edge(src = 3, dest = 6, weight = 8),
    )

    val result = minSpanningTree(edges)

    println(result)
    require(result == listOf(Edge(2, 3, 4), Edge(0, 3, 5), Edge(0, 1, 10)))
}