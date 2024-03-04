@file:Problem(topics = [Topic.Array, Topic.Matrix])

package leetcode.`54-spiral-matrix`

enum class Direction { Right, Down, Left, Top }

// n - number of elements in the output list.
@TimeComplexity("O(n)")
@SpaceComplexity("O(n)")
fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val size = matrix.size * matrix[0].size
    val result = mutableListOf<Int>()

    var right = matrix[0].lastIndex
    var bottom = matrix.lastIndex
    var top = 1
    var left = 0

    var currDir = Direction.Right
    var row = 0
    var col = 0

    while (result.size < size) {
        result += matrix[row][col]

        when (currDir) {
            Direction.Right -> {
                if (col + 1 <= right) {
                    col++
                } else {
                    right--
                    row++
                    currDir = Direction.Down
                }
            }

            Direction.Down -> {
                if (row + 1 <= bottom) {
                    row++
                } else {
                    bottom--
                    col--
                    currDir = Direction.Left
                }
            }

            Direction.Left -> {
                if (col - 1 >= left) {
                    col--
                } else {
                    left++
                    row--
                    currDir = Direction.Top
                }
            }

            Direction.Top -> {
                if (row - 1 >= top) {
                    row--
                } else {
                    top++
                    col++
                    currDir = Direction.Right
                }
            }
        }
    }
    return result
}

fun main() {
    val input = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(12, 13, 14, 5),
        intArrayOf(11, 16, 15, 6),
        intArrayOf(10, 9, 8, 7),
    )

    val result = spiralOrder(input)

    println(result)
    require(result == listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16))
}