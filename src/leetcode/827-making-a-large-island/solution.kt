@file:Problem(companies = [Company.Meta], topics = [Topic.Array, Topic.Matrix, Topic.DepthFirstSearch])

package leetcode.`827-making-a-large-island`

@TimeComplexity("O(n * m)")
@SpaceComplexity("O(n * m)")
fun largestIsland(grid: Array<IntArray>): Int {
    val islandAreas = mutableListOf<Int>()
    val islandCells = Array(grid.size) { IntArray(grid[0].size) { -1 } }

    fun calculateArea(row: Int, col: Int, island: Int): Int {
        if (row !in 0..grid.lastIndex) return 0
        if (col !in 0..grid[0].lastIndex) return 0
        if (grid[row][col] == 0) return 0
        if (islandCells[row][col] != -1) return 0

        islandCells[row][col] = island

        var area = 1
        area += calculateArea(row + 1, col, island)
        area += calculateArea(row - 1, col, island)
        area += calculateArea(row, col + 1, island)
        area += calculateArea(row, col - 1, island)
        return area
    }

    for (row in grid.indices) {
        for (col in grid[0].indices) {
            if (grid[row][col] == 0) continue

            islandAreas += calculateArea(row, col, island = islandAreas.size)
        }
    }

    var maxArea = islandAreas.maxOrNull() ?: return 1

    fun findIsland(row: Int, col: Int): Int? {
        if (row !in 0..grid.lastIndex) return null
        if (col !in 0..grid[0].lastIndex) return null
        if (grid[row][col] == 0) return null

        val island = islandCells[row][col]
        return island
    }

    for (row in grid.indices) {
        for (col in grid[0].indices) {
            if (grid[row][col] == 1) continue

            val islands = mutableSetOf<Int?>()
            islands += findIsland(row + 1, col)
            islands += findIsland(row - 1, col)
            islands += findIsland(row, col + 1)
            islands += findIsland(row, col - 1)

            var area = 1
            for (island in islands.filterNotNull()) {
                area += islandAreas[island]
            }
            maxArea = maxOf(maxArea, area)
        }
    }
    return maxArea
}

fun main() {
    val input = arrayOf(
        intArrayOf(1, 0, 1),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 1)
    )

    val result = largestIsland(input)

    println(result)
    require(result == 4)
}