package foundation.graph.`breadth-first-search`.grid

typealias Graph<T> = Array<Array<out T>>

typealias Queue = ArrayDeque<Pair<Int, Int>>

// left, up, right, down
val directions = arrayOf(0 to -1, -1 to 0, 0 to 1, 1 to 0)

fun <T> Graph<T>.traverse(rootRow: Int, rootCol: Int): List<T> {
    val graph = this
    val rows = graph.size
    val cols = graph.getOrNull(0)?.size ?: 0
    require(rootRow in (0 until rows) && rootCol in (0 until cols)) {
        "Invalid root vertex ($rootRow, $rootCol)"
    }

    val explored = Array(rows) { BooleanArray(cols) }
    val result = mutableListOf<T>()
    val queue = Queue()
    queue += rootRow to rootCol

    while (queue.isNotEmpty()) {
        val (row, col) = queue.removeFirst()

        if (graph[row][col] != null && !explored[row][col]) {
            explored[row][col] = true
            result += graph[row][col]

            for ((dirRow, dirCol) in directions) {
                val nextRow = row + dirRow
                val nextCol = col + dirCol

                if (nextRow in (0 until rows) && nextCol in (0 until cols)) {
                    queue += nextRow to nextCol
                }
            }
        }
    }
    return result
}


fun main() {

    val graph = arrayOf(
        arrayOf("F", "C", null, "J"),
        arrayOf("B", "A", "D", null),
        arrayOf("G", "E", "H", "I"),
    )

    val result = graph.traverse(rootRow = 1, rootCol = 1)

    println(result)

    require(result == listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"))
}