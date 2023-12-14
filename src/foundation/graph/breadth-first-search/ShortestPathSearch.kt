package foundation.graph.`breadth-first-search`.search

typealias Graph<T> = Map<T, List<T>>

typealias Queue<T> = ArrayDeque<T>

fun <T> Graph<T>.shortestPath(root: T, target: T): List<T> {
    val graph = this
    require(root in graph) { "Invalid root vertex '$root'" }

    val parents = mutableMapOf<T, T>()
    val queue = Queue<T>()
    queue += root

    while (queue.isNotEmpty()) {
        val vertex = queue.removeFirst()
        for (successor in graph[vertex].orEmpty()) {
            if (successor !in parents) {
                parents[successor] = vertex
                queue += successor

                if (successor == target) return parents.pathTo(target)
            }
        }
    }
    return emptyList()
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
        "A" to listOf("B", "C", "D"),
        "B" to listOf("E"),
        "D" to listOf("F", "G"),
        "C" to listOf("H", "E")
    )

    val result = graph.shortestPath(root = "A", target = "E")

    println(result) // [A, B, E]

    require(result == listOf("A", "B", "E"))
}