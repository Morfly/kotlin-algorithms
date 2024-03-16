@file:Problem(companies = [Company.Meta], topics = [Topic.Array, Topic.Matrix])

package leetcode.`1901-find-a-peak-element-II`

@TimeComplexity("O(r log c)")
@SpaceComplexity("O(1)")
fun findPeakGrid(mat: Array<IntArray>): IntArray {
    var start = 0
    var end = mat[0].lastIndex

    while (start <= end) {
        val mid = (start + end) / 2

        var maxRow = 0
        for (row in mat.indices) {
            if (mat[row][mid] > mat[maxRow][mid]) {
                maxRow = row
            }
        }

        val isGreaterThanLeft = mid == 0 || mat[maxRow][mid] > mat[maxRow][mid - 1]
        val isGreaterThanRight = mid == mat[0].lastIndex || mat[maxRow][mid] > mat[maxRow][mid + 1]

        when {
            isGreaterThanLeft && isGreaterThanRight -> return intArrayOf(maxRow, mid)
            isGreaterThanLeft -> start = mid + 1
            else -> end = mid - 1
        }
    }
    return intArrayOf(0, 0)
}


fun main() {
    val input = arrayOf(
        intArrayOf(7, 2, 3, 1, 2),
        intArrayOf(6, 5, 4, 2, 1)
    )

    val result = findPeakGrid(input).toList()

    println(result)
    require(result == listOf(0, 0))
}
