package exercises.`dynamic-programming`.`count-the-paths`.recursive

typealias Grid = Array<IntArray>

// https://youtu.be/P8Xa2BitN3I?si=B8TuILrrz_2IJfCl
fun countPaths(grid: Grid): Int {
    val mem = Array(grid.size) { IntArray(grid[0].size) { 0 } }

    fun countPaths(grid: Grid, row: Int, col: Int): Int {
        if (!isValidSquare(grid, row, col)) return 0
        if (isAtEnd(grid, row, col)) return 1

        if (mem[row][col] == 0) {
            mem[row][col] = countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1)
        }

        return mem[row][col]
    }
    return countPaths(grid, row = 0, col = 0)
}

private fun isValidSquare(grid: Grid, row: Int, col: Int): Boolean {
    if (row > grid.lastIndex || col > grid[0].lastIndex) return false

    return grid[row][col] == 0
}

private fun isAtEnd(grid: Grid, row: Int, col: Int): Boolean {
    return row == grid.lastIndex && col == grid[0].lastIndex
}

fun main() {
    val grid = arrayOf(
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 0, 0, 1, 0),
        intArrayOf(0, 0, 0, 0, 1, 0, 0, 0),
        intArrayOf(1, 0, 1, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 1, 1, 0, 1, 0),
        intArrayOf(0, 1, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0),
    )

    val result = countPaths(grid)

    println(result)
}