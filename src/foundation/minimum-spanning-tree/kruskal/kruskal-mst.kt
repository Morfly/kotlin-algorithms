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
        edge(src = "A", dest = "D", weight = 1),
        edge(src = "A", dest = "B", weight = 2),
        edge(src = "B", dest = "D", weight = 3),
        edge(src = "E", dest = "D", weight = 9),
        edge(src = "E", dest = "A", weight = 4),
        edge(src = "B", dest = "C", weight = 3),
        edge(src = "C", dest = "D", weight = 5),
        edge(src = "B", dest = "F", weight = 7),
        edge(src = "C", dest = "F", weight = 8),
    )

    val result = minSpanningTree(edges)
    val totalWeight = result.sumOf { it.weight }

    println(result.joinToString("\n"))
    println(totalWeight)
    require(
        result == listOf(
            edge(src = "A", dest = "D", weight = 1),
            edge(src = "A", dest = "B", weight = 2),
            edge(src = "B", dest = "C", weight = 3),
            edge(src = "E", dest = "A", weight = 4),
            edge(src = "B", dest = "F", weight = 7)
        )
    )
    require(totalWeight == 17)
}

fun edge(src: String, dest: String, weight: Int) = Edge(src, dest, weight)
