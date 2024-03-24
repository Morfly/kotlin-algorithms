@file:Problem(companies = [Company.Meta], topics = [Topic.Matrix, Topic.Array], comment = "*")

package leetcode.`73-set-matrix-zeroes`

@TimeComplexity("O(n * m)")
@SpaceComplexity("O(1)")
fun setZeroes(matrix: Array<IntArray>) {
    var firstRowZero = false
    var firstColZero = false
    for (row in matrix.indices) {
        for (col in matrix[0].indices) {
            if (matrix[row][col] == 0) {
                if (row == 0) firstRowZero = true
                if (col == 0) firstColZero = true
                matrix[0][col] = 0
                matrix[row][0] = 0
            }
        }
    }

    for (row in 1..matrix.lastIndex) {
        for (col in 1..matrix[0].lastIndex) {
            if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                matrix[row][col] = 0
            }
        }
    }

    if (firstRowZero) {
        for (col in matrix[0].indices) {
            matrix[0][col] = 0
        }
    }

    if (firstColZero) {
        for (row in matrix.indices) {
            matrix[row][0] = 0
        }
    }
}

fun main() {
    val input = arrayOf(
        intArrayOf(0, 1, 2, 5),
        intArrayOf(3, 4, 0, 2),
        intArrayOf(1, 3, 1, 5)
    )

    setZeroes(input)
    val result = input.toList().map(IntArray::toList)

    println(result)
    require(
        result == listOf(
            listOf(0, 0, 0, 0),
            listOf(0, 0, 0, 0),
            listOf(0, 3, 0, 5)
        )
    )
}