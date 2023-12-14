package foundation.graph.`depth-first-search`.recursive

typealias Graph<T> = Map<T, List<T>>


fun <T> Graph<T>.traverse(root: T): List<T> {
    val graph = this
    require(root in graph) { "Invalid root vertex '$root'" }

    val explored = linkedSetOf<T>()

    fun explore(vertex: T) {
        explored += vertex
        for (successor in graph[vertex].orEmpty()) {
            if (successor !in explored) {
                explore(successor)
            }
        }
    }
    explore(root)

    // this implementation also explores disconnected subgraphs
    for ((vertex, _) in graph) {
        if (vertex !in explored) {
            explore(vertex)
        }
    }

    return explored.toList()
}


fun main() {
    val graph = mapOf(
        // first subgraph
        "A" to listOf("B", "F", "I"),
        "B" to listOf("C"),
        "C" to listOf("D", "E"),
        "F" to listOf("G", "H"),

        // second subgraph
        "J" to listOf("K", "L", "O"),
        "L" to listOf("M", "N")
    )

    val result = graph.traverse(root = "A")

    println(result)

    require(result == listOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"))
}