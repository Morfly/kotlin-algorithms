package foundation.graph.dijkstra

typealias Graph<T> = Map<T, Map<T, Double>>

const val INFINITY = Double.POSITIVE_INFINITY

fun <T> Graph<T>.shortestPath(root: T, target: T): List<T> {
    val graph = this
    if (root !in graph) return emptyList()

    val explored = mutableSetOf<T>()
    val weights = graph[root]!!.toMutableMap()
    val parents = mutableMapOf<T, T>()
    for ((vertex, _) in graph[root]!!) {
        parents[vertex] = root
    }

    var vertex = findClosestVertex(weights, explored)
    while (vertex != null) {
        if (vertex == target) return parents.pathTo(target)
        explored += vertex
        val weight = weights[vertex]!!

        for ((successor, edgeWeight) in graph[vertex].orEmpty()) {
            if (weight + edgeWeight < (weights[successor] ?: INFINITY)) {
                weights[successor] = weight + edgeWeight
                parents[successor] = vertex
            }
        }
        vertex = findClosestVertex(weights, explored)
    }

    return emptyList()
}

private fun <T> findClosestVertex(weights: Map<T, Double>, explored: Set<T>): T? {
    var closestVertex: T? = null
    var minWeight = INFINITY
    for ((vertex, weight) in weights) {
        if (vertex !in explored && weight < minWeight) {
            closestVertex = vertex
            minWeight = weight
        }
    }
    return closestVertex
}

private fun <T> Map<T, T>.pathTo(target: T): List<T> {
    val parents = this

    val path = mutableListOf<T>()
    var vertex: T? = target

    while (vertex != null) {
        path += vertex
        vertex = parents[vertex]
    }
    return path.asReversed()
}

fun main() {
    val graph = mapOf(
        "Start" to mapOf("A" to 5.0),
        "A" to mapOf("B" to 7.0, "C" to 4.0),
        "B" to mapOf("Finish" to 4.0),
        "C" to mapOf("Finish" to 3.0),
    )

    val result = graph.shortestPath(root = "Start", target = "Finish")

    println(result)
    require(result == listOf("Start", "A", "C", "Finish"))
}