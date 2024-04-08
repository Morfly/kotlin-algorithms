package foundation.`minimum-spanning-tree`.kruskal

import foundation.`disjoint-set-union`.`hash-map`.DisjointSet

data class Edge(val src: String, val dest: String, val weight: Int)

fun minSpanningTree(edges: List<Edge>): List<Edge> {
    val minSpanningTree = mutableListOf<Edge>()
    val disjointSet = DisjointSet<String>()

    val sortedEdges = edges.sortedBy(Edge::weight)
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
        Edge(src = "A", dest = "D", weight = 1),
        Edge(src = "A", dest = "B", weight = 2),
        Edge(src = "B", dest = "D", weight = 3),
        Edge(src = "E", dest = "D", weight = 9),
        Edge(src = "E", dest = "A", weight = 4),
        Edge(src = "B", dest = "C", weight = 3),
        Edge(src = "C", dest = "D", weight = 5),
        Edge(src = "B", dest = "F", weight = 7),
        Edge(src = "C", dest = "F", weight = 8),
    )

    val result = minSpanningTree(edges)
    val totalWeight = result.sumOf { it.weight }

    println(result)
    println(totalWeight)
    require(
        result == listOf(
            Edge(src = "A", dest = "D", weight = 1),
            Edge(src = "A", dest = "B", weight = 2),
            Edge(src = "B", dest = "C", weight = 3),
            Edge(src = "E", dest = "A", weight = 4),
            Edge(src = "B", dest = "F", weight = 7)
        )
    )
    require(totalWeight == 17)
}