package foundation.graph.`topological-sort`

typealias Graph<T> = Map<T, List<T>>

fun <T> Graph<T>.traverse(root: T): List<T> {
    val graph = this
    require(root in graph) { "Invalid root vertex '$root'" }

    val explored = mutableSetOf<T>()

    fun explore(vertex: T) {
        explored += vertex
        for (successor in graph[vertex].orEmpty()) {
            if (successor != explored) {
                explore(successor)
            }
        }
    }
    explore(root)

    return explored.reversed()
}

fun main() {
    val graph = mapOf(
        "A" to listOf("B", "F", "I"),
        "B" to listOf("C"),
        "C" to listOf("D", "E"),
        "F" to listOf("G", "H"),
    )

    val result = graph.traverse(root = "A")

    println(result)
    require(result == listOf("I", "H", "G", "F", "E", "D", "C", "B", "A"))
}