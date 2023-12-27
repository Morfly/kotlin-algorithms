package leetcode.`48-rotate-image`

fun rotate(matrix: Array<IntArray>) {
    for (row in 0..matrix.lastIndex) {
        for (col in row..matrix.lastIndex) {
            matrix[row][col] = matrix[col][row].also { matrix[col][row] = matrix[row][col] }
        }
    }

    for (row in matrix) {
        row.reverse()
    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    rotate(matrix)

    val expected = arrayOf(
        intArrayOf(7, 4, 1),
        intArrayOf(8, 5, 2),
        intArrayOf(9, 6, 3)
    )
    for (row in matrix.indices) {
        for (col in matrix.indices) {
            require(matrix[row][col] == expected[row][col])
        }
    }
}