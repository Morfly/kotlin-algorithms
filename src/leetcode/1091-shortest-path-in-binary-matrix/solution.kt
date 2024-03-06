@file:Problem(companies = [Company.Meta], topics = [Topic.Array, Topic.BreadthFirstSearch, Topic.Matrix])

package leetcode.`1091-shortest-path-in-binary-matrix`

typealias Node = Pair<Int, Int>

@TimeComplexity("O(n^2)")
@SpaceComplexity("O(n^2)")
fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
    val queue = ArrayDeque<Node>()
    if (grid[0][0] == 0) queue += 0 to 0

    val validRange = 0..grid.lastIndex

    val directions = arrayOf(
        0 to 1, 1 to 0, 0 to -1, -1 to 0,
        1 to 1, -1 to 1, 1 to -1, -1 to -1,
    )
    val paths = mutableMapOf<Node, Int>()

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        val (row, col) = node

        if (row == grid.lastIndex && col == grid.lastIndex) {
            return paths.getOrDefault(node, 1)
        }

        for ((dirRow, dirCol) in directions) {
            val newRow = row + dirRow
            val newCol = col + dirCol

            if (newRow !in validRange || newCol !in validRange) continue
            if (grid[newRow][newCol] != 0) continue

            val newNode = newRow to newCol
            if (newNode in paths) continue

            paths[newNode] = paths.getOrDefault(node, 1) + 1
            queue += newNode
        }
    }
    return -1
}

fun main() {
    val input = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0)
    )

    val result = shortestPathBinaryMatrix(input)

    println(result)
    require(result == 4)
}