@file:Problem(companies = [Company.Meta], topics = [Topic.Array, Topic.Matrix, Topic.BinarySearch])

package leetcode.`74-search-a-2d-matrix`

@TimeComplexity("O(log n + log m)")
@SpaceComplexity("O(1)")
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

    fun findInRow(row: IntArray): Boolean {
        var start = 0
        var end = row.lastIndex

        while (start <= end) {
            val mid = (start + end) / 2
            val guess = row[mid]

            when {
                guess < target -> start = mid + 1
                guess > target -> end = mid - 1
                else -> return true
            }
        }
        return false
    }

    var start = 0
    var end = matrix.lastIndex

    while (start <= end) {
        val mid = (start + end) / 2
        val row = matrix[mid]

        when {
            target < row.first() -> end = mid - 1
            target > row.last() -> start = mid + 1
            else -> return findInRow(row)
        }
    }
    return false
}

fun main() {
    val input = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )

    val result = searchMatrix(input, target = 3)

    println(result)
    require(result)
}