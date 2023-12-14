package foundation.graph.`depth-first-search`.traversal.iterative

typealias Graph<T> = Map<T, List<T>>

typealias Stack<T> = ArrayDeque<T>

fun <T> Graph<T>.traverse(root: T): List<T> {
    val graph = this
    require(root in graph) { "Invalid root vertex '$root'" }

    val explored = linkedSetOf<T>()
    val stack = Stack<T>()
    stack += root

    while (stack.isNotEmpty()) {
        val vertex = stack.removeLast()
        if (vertex !in explored) {
            explored += vertex
            stack += graph[vertex].orEmpty()
        }
    }

    return explored.toList()
}


fun main() {
    val graph = mapOf(
        // first subgraph
        "A" to listOf("I", "F", "B"),
        "B" to listOf("C"),
        "C" to listOf("E", "D"),
        "F" to listOf("H", "G"),

        // second subgraph
        "J" to listOf("K", "L", "M"),
        "L" to listOf("N", "O")
    )

    val result = graph.traverse(root = "A")

    println(result)

    require(result == listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"))
}