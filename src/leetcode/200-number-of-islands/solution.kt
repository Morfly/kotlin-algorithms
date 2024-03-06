@file:Problem(companies = [Company.Meta], topics = [Topic.Array, Topic.Matrix, Topic.BreadthFirstSearch])

package leetcode.`200-number-of-islands`

@TimeComplexity("O(m * n)")
@SpaceComplexity("O(1)")
fun numIslands(grid: Array<CharArray>): Int {
    var numIslands = 0

    fun explore(row: Int, col: Int) {
        if (row !in 0..grid.lastIndex) return
        if (col !in 0..grid[0].lastIndex) return
        if (grid[row][col] == '0') return

        grid[row][col] = '0'

        explore(row + 1, col)
        explore(row - 1, col)
        explore(row, col + 1)
        explore(row, col - 1)
    }

    for (row in grid.indices) {
        for (col in grid[0].indices) {
            if (grid[row][col] == '1') {
                explore(row, col)
                numIslands++
            }
        }
    }
    return numIslands
}

fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1'),
    )

    val result = numIslands(grid)

    println(result)
    require(result == 3)
}