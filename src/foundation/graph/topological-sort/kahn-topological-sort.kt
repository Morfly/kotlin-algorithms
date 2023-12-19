package foundation.graph.`topological-sort`.kahn

typealias Graph<T> = Map<T, List<T>>

typealias Queue<T> = ArrayDeque<T>

fun <T> Graph<T>.topologicalSort(): List<T> {
    val graph = this
    val incomingEdges = mutableMapOf<T, Int>()
    for ((vertex, successors) in graph) {
        if (vertex !in incomingEdges) {
            incomingEdges[vertex] = 0
        }
        for (successor in successors) {
            incomingEdges[successor] = incomingEdges.getOrDefault(successor, 0) + 1
        }
    }

    val queue = Queue<T>()
    for ((vertex, edges) in incomingEdges) {
        if (edges == 0) queue += vertex
    }

    val result = mutableListOf<T>()

    while (queue.isNotEmpty()) {
        val vertex = queue.removeFirst()
        result += vertex

        for (successor in graph[vertex].orEmpty()) {
            incomingEdges[successor] = incomingEdges.getOrDefault(successor, 0) - 1
            if (incomingEdges[successor] == 0) {
                queue += successor
            }
        }
    }

    if (result.size != incomingEdges.size) {
        error("Graph contains a cycle, topological sort not possible!")
    }

    return result
}

fun main() {
    // u → v means v depends on u
    val graph = mapOf(
        "A" to listOf("B", "C", "D"),
        "B" to listOf("E"),
        "C" to listOf("F", "G"),
        "F" to listOf("H", "I"),
    )

    val result = graph.topologicalSort()

    println(result)
    require(result == listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"))
}