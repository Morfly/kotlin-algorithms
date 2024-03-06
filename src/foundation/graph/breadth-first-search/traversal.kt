@file:GraphAlgorithm(directed.both, cyclic.both, weighted.both)

package foundation.graph.`breadth-first-search`.traversal

typealias Graph<T> = Map<T, List<T>>

typealias Queue<T> = ArrayDeque<T>

fun <T> Graph<T>.traverse(root: T): List<T> {
    val graph = this
    require(root in graph) { "Invalid root vertex '$root'" }

    val explored = linkedSetOf<T>()
    val queue = Queue<T>()
    queue += root

    while (queue.isNotEmpty()) {
        val vertex = queue.removeFirst()
        if (vertex !in explored) {
            explored += vertex
            queue += graph[vertex].orEmpty()
        }
    }

    return explored.toList()
}

fun main() {
    val graph = mapOf(
        // first subgraph
        "A" to listOf("B", "C", "D"),
        "B" to listOf("E"),
        "C" to listOf("F", "G"),
        "F" to listOf("H", "I"),

        // second subgraph
        "J" to listOf("K", "L", "M"),
        "L" to listOf("N", "O")
    )

    val result = graph.traverse(root = "A")

    println(result)
    require(result == listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"))
}
