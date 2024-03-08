@file:Problem(companies = [Company.Meta], topics = [Topic.Array, Topic.Matrix, Topic.DepthFirstSearch])

package leetcode.`695-max-area-of-islands`

@TimeComplexity("O(n * m)")
@SpaceComplexity("O(1)")
fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    var maxArea = 0

    fun traverse(row: Int, col: Int): Int {
        if (row !in 0..grid.lastIndex) return 0
        if (col !in 0..grid[0].lastIndex) return 0
        if (grid[row][col] == 0) return 0

        grid[row][col] = 0

        var area = 1
        area += traverse(row + 1, col)
        area += traverse(row - 1, col)
        area += traverse(row, col + 1)
        area += traverse(row, col - 1)
        return area
    }

    for (row in grid.indices) {
        for (col in grid[0].indices) {
            if (grid[row][col] == 0) continue
            val area = traverse(row, col)
            maxArea = maxOf(maxArea, area)
        }
    }
    return maxArea
}

fun main() {
    val input = arrayOf(
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
    )

    val result = maxAreaOfIsland(input)

    println(result)
    require(result == 6)
}